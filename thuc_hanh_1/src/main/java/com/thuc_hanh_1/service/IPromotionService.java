package com.thuc_hanh_1.service;

import com.thuc_hanh_1.model.Promotion;

import java.util.List;
import java.util.Optional;

public interface IPromotionService {
    Iterable<Promotion> getAllPromotions();
    Optional<Promotion> getPromotionById(Long id);
    void savePromotion(Promotion promotion);
    void deletePromotion(Long id);
    List<Promotion> getPromotionsByDiscountRate(Double discountRate);
}
