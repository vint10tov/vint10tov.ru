package ru.v10tov.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.v10tov.services.PriceService;

@Controller
@RequiredArgsConstructor
public class AdminPriceController {

    @GetMapping("/admin/price")
    public String adminPriceGet(Model model) {
        return "admin-price";
    }

    @Autowired
    private PriceService priceService;

    @PostMapping("/admin/price/create")
    public String addPrice(@RequestParam("file") MultipartFile file) {
        priceService.savePrice(file);
        return "redirect:/admin/price";
    }
}
