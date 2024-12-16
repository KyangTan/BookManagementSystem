package com.bufstudio.bookmanagementsystem.repository.promo;

import com.bufstudio.bookmanagementsystem.model.entity.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long>, JpaSpecificationExecutor<Promo> {
}
