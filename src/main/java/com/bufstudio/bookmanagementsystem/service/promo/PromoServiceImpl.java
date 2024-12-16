package com.bufstudio.bookmanagementsystem.service.promo;

import com.bufstudio.bookmanagementsystem.model.dto.promo.PromoCriteriaDto;
import com.bufstudio.bookmanagementsystem.model.dto.promo.PromoDto;
import com.bufstudio.bookmanagementsystem.repository.promo.PromoRepository;
import com.bufstudio.bookmanagementsystem.repository.promo_criteria.PromoCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    PromoRepository promoRepository;

    @Autowired
    PromoCriteriaRepository promoCriteriaRepository;

    @Override
    public List<PromoDto> getAllPromos() {
        return List.of();
    }

    @Override
    public Optional<PromoDto> getPromoById(Long id) {
        return Optional.empty();
    }

    @Override
    public PromoDto createPromo(String name, String promoCode, BigDecimal discountRate, LocalDateTime effectiveStartTimestamp, LocalDateTime effectiveEndTimestamp) {
        return null;
    }

    @Override
    public Optional<PromoDto> updatePromo(Long id, String name, String promoCode, BigDecimal discountRate, LocalDateTime effectiveStartTimestamp, LocalDateTime effectiveEndTimestamp) {
        return Optional.empty();
    }

    @Override
    public boolean deletePromo(Long id) {
        return false;
    }

    @Override
    public Optional<PromoCriteriaDto> createPromoCriteria(Long promoId, String description, String conditionType, String conditionValue) {
        return Optional.empty();
    }

    @Override
    public List<PromoCriteriaDto> getCriteriaForPromo(Long promoId) {
        return List.of();
    }

    @Override
    public Optional<PromoCriteriaDto> updatePromoCriteria(Long id, String description, String conditionType, String conditionValue) {
        return Optional.empty();
    }

    @Override
    public boolean deletePromoCriteria(Long id) {
        return false;
    }
}
