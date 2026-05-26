package com.bfhl;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import com.bfhl.service.BfhlService;
import com.bfhl.service.BfhlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BfhlServiceTest {

    private BfhlService bfhlService;

    @BeforeEach
    void setUp() {
        bfhlService = new BfhlServiceImpl();
    }

    @Test
    @DisplayName("Example A: mixed data processing")
    void testExampleA() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("a", "1", "334", "4", "R", "$"));
        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertEquals("piyush_ghoshi_03012005", response.getUserId());
        assertEquals("piyushghoshi8770@gmail.com", response.getEmail());
        assertEquals("0827IT231098", response.getRollNumber());
        assertEquals(List.of("1"), response.getOddNumbers());
        assertEquals(List.of("334", "4"), response.getEvenNumbers());
        assertEquals(List.of("A", "R"), response.getAlphabets());
        assertEquals(List.of("$"), response.getSpecialCharacters());
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcatString());
    }

    @Test
    @DisplayName("Example B: numbers, alphabets, and multiple special chars")
    void testExampleB() {
        BfhlRequest request = new BfhlRequest(
                Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(List.of("5"), response.getOddNumbers());
        assertEquals(List.of("2", "4", "92"), response.getEvenNumbers());
        assertEquals(List.of("A", "Y", "B"), response.getAlphabets());
        assertEquals(List.of("&", "-", "*"), response.getSpecialCharacters());
        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcatString());
    }

    @Test
    @DisplayName("Example C: multi-character alphabetic strings with concat logic")
    void testExampleC() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("A", "ABCD", "DOE"));
        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertTrue(response.getOddNumbers().isEmpty());
        assertTrue(response.getEvenNumbers().isEmpty());
        assertEquals(List.of("A", "ABCD", "DOE"), response.getAlphabets());
        assertTrue(response.getSpecialCharacters().isEmpty());
        assertEquals("0", response.getSum());
        assertEquals("EoDdCbAa", response.getConcatString());
    }

    @Test
    @DisplayName("Empty data array returns success with empty results")
    void testEmptyDataArray() {
        BfhlRequest request = new BfhlRequest(Collections.emptyList());
        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertTrue(response.getOddNumbers().isEmpty());
        assertTrue(response.getEvenNumbers().isEmpty());
        assertTrue(response.getAlphabets().isEmpty());
        assertTrue(response.getSpecialCharacters().isEmpty());
        assertEquals("0", response.getSum());
        assertEquals("", response.getConcatString());
    }

    @Test
    @DisplayName("Null data returns error response")
    void testNullData() {
        BfhlRequest request = new BfhlRequest(null);
        BfhlResponse response = bfhlService.processData(request);

        assertFalse(response.isSuccess());
        assertNotNull(response.getMessage());
    }

    @Test
    @DisplayName("Null request returns error response")
    void testNullRequest() {
        BfhlResponse response = bfhlService.processData(null);

        assertFalse(response.isSuccess());
        assertNotNull(response.getMessage());
    }

    @Test
    @DisplayName("Negative numbers are handled correctly")
    void testNegativeNumbers() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("-3", "-2", "0"));
        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(List.of("-3"), response.getOddNumbers());
        assertEquals(List.of("-2", "0"), response.getEvenNumbers());
        assertEquals("-5", response.getSum());
    }

    @Test
    @DisplayName("Single character elements processed correctly")
    void testSingleCharElements() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("z", "!"));
        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(List.of("Z"), response.getAlphabets());
        assertEquals(List.of("!"), response.getSpecialCharacters());
        assertEquals("0", response.getSum());
        assertEquals("Z", response.getConcatString());
    }
}
