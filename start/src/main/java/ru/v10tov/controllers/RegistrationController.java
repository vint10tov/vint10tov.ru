package ru.v10tov.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.v10tov.entity.UserEntity;
import ru.v10tov.services.UserService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration/client")
    public String registrationClient() {
        return "registration";
    }

    @GetMapping("/registration/master")
    public String registrationMaster() {
        return "registration";
    }

    @PostMapping("/registration/client")
    public String createClient(UserEntity userEntity, Model model) {
        if (!userService.createClient(userEntity)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + userEntity.getEmail() + "уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @PostMapping("/registration/master")
    public String createMaster(UserEntity userEntity, Model model) {
        if (!userService.createMaster(userEntity)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + userEntity.getEmail() + "уже существует");
            return "registration";
        }
        return "redirect:/login";
    }
}
