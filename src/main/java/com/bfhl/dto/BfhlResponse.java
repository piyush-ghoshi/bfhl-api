package com.bfhl.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 * Response DTO for the /bfhl endpoint.
 * Uses @JsonProperty to ensure snake_case JSON field names.
 * Null fields are excluded from serialization.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BfhlResponse {

    @JsonProperty("is_success")
    private boolean success;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("roll_number")
    private String rollNumber;

    @JsonProperty("odd_numbers")
    private List<String> oddNumbers;

    @JsonProperty("even_numbers")
    private List<String> evenNumbers;

    @JsonProperty("alphabets")
    private List<String> alphabets;

    @JsonProperty("special_characters")
    private List<String> specialCharacters;

    @JsonProperty("sum")
    private String sum;

    @JsonProperty("concat_string")
    private String concatString;

    @JsonProperty("message")
    private String message;

    public BfhlResponse() {
    }

    // ----- Static factory methods -----

    /**
     * Creates a successful response with processed data.
     */
    public static BfhlResponse success(List<String> oddNumbers, List<String> evenNumbers,
                                       List<String> alphabets, List<String> specialCharacters,
                                       String sum, String concatString) {
        BfhlResponse resp = new BfhlResponse();
        resp.success = true;
        resp.userId = "piyush_ghoshi_03012005";
        resp.email = "piyushghoshi8770@gmail.com";
        resp.rollNumber = "0827IT231098";
        resp.oddNumbers = oddNumbers != null ? oddNumbers : Collections.emptyList();
        resp.evenNumbers = evenNumbers != null ? evenNumbers : Collections.emptyList();
        resp.alphabets = alphabets != null ? alphabets : Collections.emptyList();
        resp.specialCharacters = specialCharacters != null ? specialCharacters : Collections.emptyList();
        resp.sum = sum;
        resp.concatString = concatString;
        return resp;
    }

    /**
     * Creates an error response when input is invalid.
     */
    public static BfhlResponse error(String errorMessage) {
        BfhlResponse resp = new BfhlResponse();
        resp.success = false;
        resp.userId = "piyush_ghoshi_03012005";
        resp.email = "piyushghoshi8770@gmail.com";
        resp.rollNumber = "0827IT231098";
        resp.message = errorMessage;
        return resp;
    }

    // ----- Getters -----

    public boolean isSuccess() {
        return success;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public List<String> getOddNumbers() {
        return oddNumbers;
    }

    public List<String> getEvenNumbers() {
        return evenNumbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public List<String> getSpecialCharacters() {
        return specialCharacters;
    }

    public String getSum() {
        return sum;
    }

    public String getConcatString() {
        return concatString;
    }

    public String getMessage() {
        return message;
    }

    // ----- Setters -----

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setOddNumbers(List<String> oddNumbers) {
        this.oddNumbers = oddNumbers;
    }

    public void setEvenNumbers(List<String> evenNumbers) {
        this.evenNumbers = evenNumbers;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public void setSpecialCharacters(List<String> specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void setConcatString(String concatString) {
        this.concatString = concatString;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
