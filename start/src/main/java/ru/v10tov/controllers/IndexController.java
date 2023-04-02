package ru.v10tov.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.v10tov.entity.ObjectEntity;
import ru.v10tov.entity.UserEntity;
import ru.v10tov.services.ObjectService;
import ru.v10tov.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller("/")
@RequiredArgsConstructor
public class IndexController {

    private final ObjectService objectService;

    @GetMapping("/")
    public String indexGet() {
        return "index";
    }


    @GetMapping("/objects")
    public String objectsGet(Model model) {
        model.addAttribute("objects", objectService.objectEntityList());
        return "objects";
    }

    @GetMapping("/contacts")
    public String contactsGet() {
        return "contacts";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }
}