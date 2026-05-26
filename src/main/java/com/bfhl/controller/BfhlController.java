package com.bfhl.controller;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import com.bfhl.service.BfhlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * REST controller for the BFHL API.
 * Provides POST /bfhl for data processing and GET /health for health checks.
 */
@RestController
public class BfhlController {

    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    /**
     * POST /bfhl — Processes the input data array and returns categorized results.
     *
     * @param request the request body containing the data array
     * @return 200 OK with processed response
     */
    @PostMapping("/bfhl")
    public ResponseEntity<BfhlResponse> processData(@Valid @RequestBody BfhlRequest request) {
        BfhlResponse response = bfhlService.processData(request);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /health — Health check endpoint.
     *
     * @return 200 OK with service status information
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("service", "BFHL API");
        response.put("user_id", "piyush_ghoshi_03012005");
        return ResponseEntity.ok(response);
    }
}
