package com.bfhl.service;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of {@link BfhlService}.
 * Processes input data to categorize numbers, alphabets, and special characters,
 * compute sum, and generate the alternating-caps reversed concat string.
 */
@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public BfhlResponse processData(BfhlRequest request) {
        // Handle null request or null data gracefully
        if (request == null || request.getData() == null) {
            return BfhlResponse.error("Invalid input: data field is required");
        }

        List<String> data = request.getData();
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        long sum = 0;

        for (String item : data) {
            if (item == null || item.isEmpty()) {
                continue;
            }

            if (isInteger(item)) {
                // Valid integer string
                long num = Long.parseLong(item);
                sum += num;
                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            } else if (isPurelyAlphabetic(item)) {
                // Purely alphabetic string (single or multi-char)
                alphabets.add(item.toUpperCase());
            } else if (isSpecialCharacter(item)) {
                // Non-alphanumeric string
                specialCharacters.add(item);
            }
            // Mixed strings (e.g., "a1") don't fit any category — skip
        }

        String concatString = buildConcatString(alphabets);

        return BfhlResponse.success(
                oddNumbers,
                evenNumbers,
                alphabets,
                specialCharacters,
                String.valueOf(sum),
                concatString
        );
    }

    /**
     * Checks if a string is a valid integer (handles negatives and leading zeros).
     */
    private boolean isInteger(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if a string is purely alphabetic (A-Z, a-z).
     */
    private boolean isPurelyAlphabetic(String s) {
        return s.chars().allMatch(Character::isLetter);
    }

    /**
     * Checks if a string contains only non-alphanumeric characters.
     */
    private boolean isSpecialCharacter(String s) {
        return s.chars().noneMatch(Character::isLetterOrDigit);
    }

    /**
     * Builds the concat_string by:
     * 1. Flattening all characters from all alphabetic elements
     * 2. Reversing the character list
     * 3. Applying alternating caps (index 0 → upper, index 1 → lower, ...)
     * 4. Concatenating into a single string
     */
    private String buildConcatString(List<String> alphabets) {
        if (alphabets == null || alphabets.isEmpty()) {
            return "";
        }

        // Step 1: Flatten all characters from alphabetic elements
        List<Character> allChars = new ArrayList<>();
        for (String alpha : alphabets) {
            for (char c : alpha.toCharArray()) {
                allChars.add(c);
            }
        }

        // Step 2: Reverse the character list
        Collections.reverse(allChars);

        // Step 3: Apply alternating caps
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < allChars.size(); i++) {
            char c = allChars.get(i);
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
}
