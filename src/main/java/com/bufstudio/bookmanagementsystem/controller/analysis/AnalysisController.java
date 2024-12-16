package com.bufstudio.bookmanagementsystem.controller.analysis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/analysis")
public interface AnalysisController {

    @GetMapping("/top-selling-books")
    ResponseEntity<Map<String, Object>> getTopSellingBooks(@RequestParam(required = false) Integer limit);

    @GetMapping("/top-earning-books")
    ResponseEntity<Map<String, Object>> getTopEarningBooks(@RequestParam(required = false) Integer limit);


}
