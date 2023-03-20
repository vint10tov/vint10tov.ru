package ru.v10tov.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.v10tov.entity.UserEntity;
import ru.v10tov.entity.enums.Role;
import ru.v10tov.services.UserService;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserService userService;


    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.list());
        return "admin";
    }
    @PostMapping("/admin/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id){
        userService.banUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/user/edit/{user}")
    public String userEdit(@PathVariable("user") UserEntity userEntity, Model model){
        model.addAttribute("user", userEntity);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @PostMapping("/admin/user/edit")
    public String userEdit(@RequestParam("userId") UserEntity userEntity, @RequestParam Map<String, String> form){
        userService.changeUserRoles(userEntity, form);
        return "redirect:/admin";
    }

    @GetMapping("/admin/user/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/admin/user/registration/client")
    public String createClient(UserEntity userEntity, Model model) {
        if (!userService.createClient(userEntity)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + userEntity.getEmail() + "уже существует");
            return "registration";
        }
        return "redirect:/admin/user/registration";
    }

    @PostMapping("/admin/user/registration/master")
    public String createMaster(UserEntity userEntity, Model model) {
        if (!userService.createMaster(userEntity)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + userEntity.getEmail() + "уже существует");
            return "registration";
        }
        return "redirect:/admin/user/registration";
    }
}
