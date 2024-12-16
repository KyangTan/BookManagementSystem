package com.bufstudio.bookmanagementsystem.repository.promo_criteria;

import com.bufstudio.bookmanagementsystem.model.entity.PromoCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromoCriteriaRepository extends JpaRepository<PromoCriteria, Long>, JpaSpecificationExecutor<PromoCriteria> {
    List<PromoCriteria> findByPromoId(Long promoId);
}
