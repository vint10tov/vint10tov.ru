package ru.v10tov.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.v10tov.services.PriceService;

@Controller("/services")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/services")
    public String servicesGet(Model model) {
        return "services";
    }

    @GetMapping("/services/price-electrician")
    public String priceElectrician(Model model) {
        model.addAttribute("price", priceService.listPriceElectrician());
        return "price";
    }
    @GetMapping("/services/price-finishing")
    public String priceFinishing(Model model) {
        model.addAttribute ("price", priceService.listPriceFinishing());
        return "price";
    }
    @GetMapping("/services/price-plumbing")
    public String pricePlumbing(Model model) {
        model.addAttribute("price", priceService.listPricePlumbing());
        return "price";
    }
    @GetMapping("/services/price-air-conditioners")
    public String priceAirConditioners(Model model) {
        model.addAttribute("price", priceService.listPriceAirConditioners());
        return "price";
    }
    @GetMapping("services/price-design")
    public String priceDesign(Model model) {
        model.addAttribute("price", priceService.listPriceDesign());
        return "price";
    }
}