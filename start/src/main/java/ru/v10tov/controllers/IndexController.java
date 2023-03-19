package ru.v10tov.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.v10tov.entity.ObjectEntity;
import ru.v10tov.services.ObjectService;

import java.io.IOException;
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
    @PostMapping("/objects/create")
    public String createObject(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                               @RequestParam("file3") MultipartFile file3, @RequestParam("file4") MultipartFile file4,
                               @RequestParam("file5") MultipartFile file5, @RequestParam("file6") MultipartFile file6,
                               @RequestParam("file7") MultipartFile file7, @RequestParam("file8") MultipartFile file8,
                               @RequestParam("file9") MultipartFile file9, @RequestParam("file10") MultipartFile file10,
                               ObjectEntity objectEntity) throws IOException {
        objectService.saveObject(objectEntity, file1, file2, file3, file4, file5, file6, file7, file8, file9, file10);
        return "redirect:/objects";
    }

    @GetMapping("/contacts")
    public String contactsGet() {
        return "contacts";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }
}