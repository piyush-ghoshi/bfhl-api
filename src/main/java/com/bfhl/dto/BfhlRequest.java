package com.bfhl.dto;

import java.util.List;

/**
 * Request DTO for the /bfhl endpoint.
 * Contains a list of string data elements to process.
 */
public class BfhlRequest {

    private List<String> data;

    public BfhlRequest() {
    }

    public BfhlRequest(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
