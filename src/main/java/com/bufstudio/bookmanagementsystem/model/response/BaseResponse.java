package com.bufstudio.bookmanagementsystem.model.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class BaseResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 8638613813621704569L;

    private String traceId;
    private String message;
    private HttpStatus code;
    private Boolean success;
    private T data;

    public BaseResponse(String traceId, String message, HttpStatus code, Boolean success, T data){
        Map<String,Object> response = new HashMap<>();
        response.put("traceId", traceId);
        response.put("message", message);
        response.put("code", code);
        response.put("success", success);
        response.put("data", data);
    }

}
