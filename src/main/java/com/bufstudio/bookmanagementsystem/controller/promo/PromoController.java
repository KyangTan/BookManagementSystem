package com.bufstudio.bookmanagementsystem.controller.promo;

import com.bufstudio.bookmanagementsystem.model.entity.Promo;
import com.bufstudio.bookmanagementsystem.model.entity.PromoCriteria;
import com.bufstudio.bookmanagementsystem.model.request.promo.CreatePromoCriteriaRequest;
import com.bufstudio.bookmanagementsystem.model.request.promo.CreatePromoRequest;
import com.bufstudio.bookmanagementsystem.model.request.promo.UpdatePromoCriteriaRequest;
import com.bufstudio.bookmanagementsystem.model.request.promo.UpdatePromoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/promos")
public interface PromoController {

    @PostMapping
    ResponseEntity<Map<String, Object>> createPromo(@RequestBody CreatePromoRequest promo);

    @GetMapping
    ResponseEntity<Map<String, Object>> getAllPromos();

    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> getPromoById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Map<String, Object>> updatePromo(@PathVariable Long id, @RequestBody UpdatePromoRequest updatedPromo);

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String, Object>> deletePromo(@PathVariable Long id);

    @PostMapping("/{promoId}/criteria")
    ResponseEntity<Map<String, Object>> createPromoCriteria(@PathVariable Long promoId, @RequestBody CreatePromoCriteriaRequest promoCriteria);

    @GetMapping("/{promoId}/criteria")
    ResponseEntity<Map<String, Object>> getCriteriaForPromo(@PathVariable Long promoId);

    @PutMapping("/criteria/{id}")
    ResponseEntity<Map<String, Object>> updatePromoCriteria(@PathVariable Long id, @RequestBody UpdatePromoCriteriaRequest updatedCriteria);

    @DeleteMapping("/criteria/{id}")
    ResponseEntity<Map<String, Object>> deletePromoCriteria(@PathVariable Long id);
}
