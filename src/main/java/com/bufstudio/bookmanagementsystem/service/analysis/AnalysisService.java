package com.bufstudio.bookmanagementsystem.service.analysis;

import com.bufstudio.bookmanagementsystem.model.dto.analysis.TopEarningBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.analysis.TopSellingBookDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnalysisService {

    List<TopSellingBookDto> generateTopSellingBooksReport(Integer topN);

    List<TopEarningBookDto> generateTopEarningBooksReport(Integer topN);
}
