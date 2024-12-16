package com.bufstudio.bookmanagementsystem.service.promo;

import com.bufstudio.bookmanagementsystem.model.dto.promo.PromoCriteriaDto;
import com.bufstudio.bookmanagementsystem.model.dto.promo.PromoDto;
import com.bufstudio.bookmanagementsystem.model.entity.*;

import com.bufstudio.bookmanagementsystem.repository.Promotedorder.PromotedOrderRepository;
import com.bufstudio.bookmanagementsystem.repository.order.OrderRepository;
import com.bufstudio.bookmanagementsystem.repository.promo.PromoRepository;
import com.bufstudio.bookmanagementsystem.repository.promo_criteria.PromoCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    PromoRepository promoRepository;

    @Autowired
    PromoCriteriaRepository promoCriteriaRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PromotedOrderRepository promotedOrderRepository;

    @Override
    public List<PromoDto> getAllPromos() {
        return promoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PromoDto> getPromoById(Long id) {
        return promoRepository.findById(id).map(this::convertToDto);
    }

    @Override
    @Transactional
    public PromoDto createPromo(String name, String promoCode, BigDecimal discountRate, LocalDateTime effectiveStartTimestamp, LocalDateTime effectiveEndTimestamp) {
        Promo promo = new Promo();
        promo.setName(name);
        promo.setPromoCode(promoCode);
        promo.setDiscountRate(discountRate);
        promo.setEffectiveStartTimestamp(effectiveStartTimestamp);
        promo.setEffectiveEndTimestamp(effectiveEndTimestamp);

        Promo savedPromo = promoRepository.save(promo);
        return convertToDto(savedPromo);
    }

    @Override
    @Transactional
    public Optional<PromoDto> updatePromo(Long id, String name, String promoCode, BigDecimal discountRate, LocalDateTime effectiveStartTimestamp, LocalDateTime effectiveEndTimestamp) {
        return promoRepository.findById(id).map(promo -> {
            promo.setName(name);
            promo.setPromoCode(promoCode);
            promo.setDiscountRate(discountRate);
            promo.setEffectiveStartTimestamp(effectiveStartTimestamp);
            promo.setEffectiveEndTimestamp(effectiveEndTimestamp);

            Promo updatedPromo = promoRepository.save(promo);
            recalculateOrdersForPromo(updatedPromo);
            return convertToDto(updatedPromo);
        });
    }

    @Override
    @Transactional
    public boolean deletePromo(Long id) {
        return promoRepository.findById(id).map(promo -> {
            promoRepository.save(promo);
            recalculateOrdersForPromo(promo);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional
    public Optional<PromoCriteriaDto> createPromoCriteria(Long promoId, String description, String conditionType, String conditionValue) {
        return promoRepository.findById(promoId).map(promo -> {
            PromoCriteria criteria = new PromoCriteria();
            criteria.setPromo(promo);
            criteria.setDescription(description);
            criteria.setConditionType(conditionType);
            criteria.setConditionValue(conditionValue);

            PromoCriteria savedCriteria = promoCriteriaRepository.save(criteria);
            return convertToCriteriaDto(savedCriteria);
        });
    }

    @Override
    public List<PromoCriteriaDto> getCriteriaForPromo(Long promoId) {
        return promoCriteriaRepository.findByPromoId(promoId).stream()
                .map(this::convertToCriteriaDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<PromoCriteriaDto> updatePromoCriteria(Long id, String description, String conditionType, String conditionValue) {
        return promoCriteriaRepository.findById(id).map(criteria -> {
            criteria.setDescription(description);
            criteria.setConditionType(conditionType);
            criteria.setConditionValue(conditionValue);
            return convertToCriteriaDto(promoCriteriaRepository.save(criteria));
        });
    }

    @Override
    @Transactional
    public boolean deletePromoCriteria(Long id) {
        return promoCriteriaRepository.findById(id).map(criteria -> {
            promoCriteriaRepository.delete(criteria);
            return true;
        }).orElse(false);
    }

    // 将 Promo 实体转换为 PromoDto
    private PromoDto convertToDto(Promo promo) {
        PromoDto dto = new PromoDto();
        dto.setId(promo.getId());
        dto.setName(promo.getName());
        dto.setPromoCode(promo.getPromoCode());
        dto.setDiscountRate(promo.getDiscountRate());
        dto.setEffectiveStartTimestamp(promo.getEffectiveStartTimestamp());
        dto.setEffectiveEndTimestamp(promo.getEffectiveEndTimestamp());
        return dto;
    }

    // 将 PromoCriteria 实体转换为 PromoCriteriaDto
    private PromoCriteriaDto convertToCriteriaDto(PromoCriteria criteria) {
        PromoCriteriaDto dto = new PromoCriteriaDto();
        dto.setId(criteria.getId());
        dto.setDescription(criteria.getDescription());
        dto.setConditionType(criteria.getConditionType());
        dto.setConditionValue(criteria.getConditionValue());
        return dto;
    }

    // 重新计算与促销关联的订单总价
    private void recalculateOrdersForPromo(Promo promo) {
        List<PromotedOrder> promotedOrders = promotedOrderRepository.findByPromoId(promo.getId());
        for (PromotedOrder promotedOrder : promotedOrders) {
            Order order = promotedOrder.getOrder();
            recalculateOrderTotal(order);
        }
    }

    // 重新计算订单总价
    private void recalculateOrderTotal(Order order) {
        BigDecimal originalTotal = order.getOrderedBooks().stream()
                .map(orderedBook -> orderedBook.getBook().getPrice().multiply(BigDecimal.valueOf(orderedBook.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotalPrice(originalTotal);
        orderRepository.save(order);
    }

}
