package com.bufstudio.bookmanagementsystem.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TraceUtil {
    public static String generateTraceId() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String uniqueId = UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        return timestamp + "-" + uniqueId;
    }
}
