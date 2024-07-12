package com.thuc_hanh_1.controller;

import com.thuc_hanh_1.model.Promotion;
import com.thuc_hanh_1.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @GetMapping
    public ModelAndView listPromotion(@RequestParam(required = false) Double discountRate){
        ModelAndView modelAndView = new ModelAndView("/list");
        if(discountRate != null){
            modelAndView.addObject("promotions", promotionService.getPromotionsByDiscountRate(discountRate));
        } else {
            modelAndView.addObject("promotions", promotionService.getAllPromotions());
        }
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("promotion", new Promotion());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createPromotion(@ModelAttribute("promotion") Promotion promotion){
        promotionService.savePromotion(promotion);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("promotion", promotion);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Long id){
        Optional<Promotion> promotion = promotionService.getPromotionById(id);
        if(promotion.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/update");
            modelAndView.addObject("promotion", promotion.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update")
    public ModelAndView updatePromotion(@ModelAttribute("promotion") Promotion promotion){
        promotionService.savePromotion(promotion);
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("promotion", promotion);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deletePromotion(@RequestParam("id") Long id){
        promotionService.deletePromotion(id);
        return "redirect:/promotions";
    }
}
