package com.bfhl.service;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;

/**
 * Service interface for processing BFHL data.
 */
public interface BfhlService {

    /**
     * Processes the input data array and returns categorized results.
     *
     * @param request the request containing data to process
     * @return response with categorized numbers, alphabets, special chars, sum, and concat string
     */
    BfhlResponse processData(BfhlRequest request);
}
