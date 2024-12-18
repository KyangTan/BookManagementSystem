package com.bufstudio.bookmanagementsystem.controller.promo;

import com.bufstudio.bookmanagementsystem.model.dto.promo.PromoCriteriaDto;
import com.bufstudio.bookmanagementsystem.model.dto.promo.PromoDto;
import com.bufstudio.bookmanagementsystem.model.entity.Promo;
import com.bufstudio.bookmanagementsystem.model.entity.PromoCriteria;
import com.bufstudio.bookmanagementsystem.model.request.promo.CreatePromoCriteriaRequest;
import com.bufstudio.bookmanagementsystem.model.request.promo.CreatePromoRequest;
import com.bufstudio.bookmanagementsystem.model.request.promo.UpdatePromoCriteriaRequest;
import com.bufstudio.bookmanagementsystem.model.request.promo.UpdatePromoRequest;
import com.bufstudio.bookmanagementsystem.service.promo.PromoService;
import com.bufstudio.bookmanagementsystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class PromoControllerImpl implements PromoController {

    @Autowired
    private PromoService promoService;

    // Create a new promo
    public ResponseEntity<Map<String, Object>> createPromo(CreatePromoRequest promo) {
        PromoDto savedPromo = promoService.createPromo(promo.getName(), promo.getPromoCode(), promo.getDiscountRate(), promo.getEffectiveStartTimestamp(), promo.getEffectiveEndTimestamp());
        return ResponseUtil.createSuccessResponse("Successfully created one promo", savedPromo);
    }

    // Get all promos
    public ResponseEntity<Map<String, Object>> getAllPromos() {
        List<PromoDto> promos = promoService.getAllPromos();
        return ResponseUtil.createSuccessResponse("Successfully retrieved all promos", promos);
    }

    // Get a promo by ID
    public ResponseEntity<Map<String, Object>> getPromoById(Long id) {
        PromoDto promo = promoService.getPromoById(id).orElseThrow(() -> new IllegalArgumentException("Promo not found"));

        return ResponseUtil.createSuccessResponse("Successfully retrieve single promo", promo);
    }

    // Update a promo
    public ResponseEntity<Map<String, Object>> updatePromo(Long id, UpdatePromoRequest updatedPromo) {
        PromoDto updatedPromoDto = promoService.updatePromo(id, updatedPromo.getName(), updatedPromo.getPromoCode(), updatedPromo.getDiscountRate(), updatedPromo.getEffectiveStartTimestamp(), updatedPromo.getEffectiveEndTimestamp()).orElseThrow(() -> new IllegalArgumentException("Promo not found"));
        return ResponseUtil.createSuccessResponse("Successfully updated promo", updatedPromoDto);
    }

    // Delete a promo
    public ResponseEntity<Map<String, Object>> deletePromo(Long id) {
        boolean isDeleted = promoService.deletePromo(id);

        return ResponseUtil.createSuccessResponse("Successfully deleted promo", isDeleted);
    }

    // Create a new promo criteria
    public ResponseEntity<Map<String, Object>> createPromoCriteria(Long promoId, CreatePromoCriteriaRequest promoCriteria) {
        PromoCriteriaDto criteria = promoService.createPromoCriteria(promoId, promoCriteria.getDescription(), promoCriteria.getConditionType(), promoCriteria.getConditionValue()).orElseThrow(() -> new IllegalArgumentException("Promo criteria not found"));
        return ResponseUtil.createSuccessResponse("Successfully created promo criteria", criteria);
    }

    // Get all criteria for a promo
    public ResponseEntity<Map<String, Object>> getCriteriaForPromo(Long promoId) {
        List<PromoCriteriaDto> criteria = promoService.getCriteriaForPromo(promoId);
        return ResponseUtil.createSuccessResponse("Successfully retrieved all criteria for promo", criteria);
    }

    // Update a promo criteria
    public ResponseEntity<Map<String, Object>> updatePromoCriteria(Long id, UpdatePromoCriteriaRequest updatedCriteria) {
        PromoCriteriaDto updatedCriteriaDto = promoService.updatePromoCriteria(id, updatedCriteria.getDescription(), updatedCriteria.getConditionType(), updatedCriteria.getConditionValue()).orElseThrow(() -> new IllegalArgumentException("Promo criteria not found"));
        return ResponseUtil.createSuccessResponse("Successfully updated promo criteria", updatedCriteriaDto);
    }

    // Delete a promo criteria
    public ResponseEntity<Map<String, Object>> deletePromoCriteria(Long id) {
        Boolean isDeleted = promoService.deletePromoCriteria(id);
        return ResponseUtil.createSuccessResponse("Successfully deleted promo criteria", isDeleted);
    }

}
