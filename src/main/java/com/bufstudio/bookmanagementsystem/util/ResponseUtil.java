package com.bufstudio.bookmanagementsystem.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseUtil {
    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    public static <T> ResponseEntity<Map<String, Object>> createResponse(Boolean success, String message, T data, HttpStatus statusCode) {
        String traceId = TraceUtil.generateTraceId();

        Map<String, Object> response = new HashMap<>();
        response.put("trace", traceId);
        response.put("message", message);
        response.put("success", success);

        if (data != null) {
            response.put("data", data);
        } else {
            response.put("data", new HashMap<>());
        }

        if (statusCode.compareTo(HttpStatus.OK) >= 0 && statusCode.compareTo(HttpStatus.MULTIPLE_CHOICES) < 0) {
            logger.info("Response: trace={}, success={}, timestamp={}", traceId, true, LocalDateTime.now());
        } else {
            logger.error("Response: trace={}, success={}, timestamp={}", traceId, false, LocalDateTime.now());
        }

        // TODO: Insert Trace Record into Database
        //       IMPLEMENTATION HERE

        return new ResponseEntity<>(response, statusCode);
    }

    public static <T> ResponseEntity<Map<String, Object>> createSuccessResponse(String message, T data) {
        return createResponse(true, message, data, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Map<String, Object>> createErrorResponse(String message) {
        return createResponse(false, message, null, HttpStatus.BAD_REQUEST);
    }
}
