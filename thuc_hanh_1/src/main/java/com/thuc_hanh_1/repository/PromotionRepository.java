package com.thuc_hanh_1.repository;

import com.thuc_hanh_1.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByDiscountRate(Double discountRate);
}
