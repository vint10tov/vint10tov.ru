package ru.v10tov.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.v10tov.entity.UserEntity;
import ru.v10tov.services.UserService;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(UserEntity userEntity, Model model) {
        if (!userService.createUser(userEntity)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + userEntity.getEmail() + "уже существует");
            return "registration";
        }
        return "redirect:/login";
    }
}
