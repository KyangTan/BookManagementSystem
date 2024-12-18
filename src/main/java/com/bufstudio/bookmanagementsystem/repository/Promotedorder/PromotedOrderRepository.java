package com.bufstudio.bookmanagementsystem.repository.Promotedorder;



import com.bufstudio.bookmanagementsystem.model.entity.PromotedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotedOrderRepository extends JpaRepository<PromotedOrder, Long> {
    List<PromotedOrder> findByPromoId(Long promoId);

}
