package com.bufstudio.bookmanagementsystem.controller.analysis;

import com.bufstudio.bookmanagementsystem.model.dto.analysis.TopEarningBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.analysis.TopSellingBookDto;
import com.bufstudio.bookmanagementsystem.service.analysis.AnalysisService;
import com.bufstudio.bookmanagementsystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AnalysisControllerImpl implements AnalysisController {

    @Autowired
    AnalysisService analysisService;

    @Override
    public ResponseEntity<Map<String, Object>> getTopSellingBooks(Integer limit) {
        List<TopSellingBookDto> topSellingBookDtos = analysisService.generateTopSellingBooksReport(limit);
        if (topSellingBookDtos == null) {
            return ResponseUtil.createSuccessResponse(
                    "No top selling books found",
                    null);
        }
        return ResponseUtil.createSuccessResponse("Top selling book retrieved", topSellingBookDtos);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getTopEarningBooks(Integer limit) {
        List<TopEarningBookDto> topEarningBookDtos = analysisService.generateTopEarningBooksReport(limit);
        if (topEarningBookDtos == null) {
            return ResponseUtil.createSuccessResponse(
                    "No top earning books found",
                    null);
        }
        return ResponseUtil.createSuccessResponse("Top earning book retrieved", topEarningBookDtos);
    }
}
