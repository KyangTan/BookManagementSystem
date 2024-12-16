package com.bufstudio.bookmanagementsystem.service.promo;

import com.bufstudio.bookmanagementsystem.model.dto.promo.PromoCriteriaDto;
import com.bufstudio.bookmanagementsystem.model.dto.promo.PromoDto;
import com.bufstudio.bookmanagementsystem.model.entity.Promo;
import com.bufstudio.bookmanagementsystem.model.entity.PromoCriteria;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface PromoService {

    List<PromoDto> getAllPromos();

    Optional<PromoDto> getPromoById(Long id);

    PromoDto createPromo(String name, String promoCode, BigDecimal discountRate, LocalDateTime effectiveStartTimestamp, LocalDateTime effectiveEndTimestamp);

    Optional<PromoDto> updatePromo(Long id, String name, String promoCode, BigDecimal discountRate, LocalDateTime effectiveStartTimestamp, LocalDateTime effectiveEndTimestamp);

    boolean deletePromo(Long id);

    Optional<PromoCriteriaDto> createPromoCriteria(Long promoId, String description, String conditionType, String conditionValue);

    List<PromoCriteriaDto> getCriteriaForPromo(Long promoId);

    Optional<PromoCriteriaDto> updatePromoCriteria(Long id, String description, String conditionType, String conditionValue);

    boolean deletePromoCriteria(Long id);

}
