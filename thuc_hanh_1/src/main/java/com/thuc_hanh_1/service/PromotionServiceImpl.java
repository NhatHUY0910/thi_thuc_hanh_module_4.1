package com.thuc_hanh_1.service;

import com.thuc_hanh_1.model.Promotion;
import com.thuc_hanh_1.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements IPromotionService{

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public Iterable<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public Optional<Promotion> getPromotionById(Long id) {
        return promotionRepository.findById(id);
    }

    @Override
    public void savePromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public List<Promotion> getPromotionsByDiscountRate(Double discountRate) {
        return promotionRepository.findByDiscountRate(discountRate);
    }
}
