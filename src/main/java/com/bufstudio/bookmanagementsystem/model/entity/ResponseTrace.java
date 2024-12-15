package com.bufstudio.bookmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "response_traces")
@Data
public class ResponseTrace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String traceId;
    private Boolean success;
    private String error;
    private LocalDateTime timestamp;
}

