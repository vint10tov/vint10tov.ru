package ru.v10tov.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.v10tov.entity.ObjectEntity;
import ru.v10tov.services.ObjectService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class AdminObjectController {

    private final ObjectService objectService;

    @GetMapping("/admin/objects")
    public String adminObjectsGet(Model model) {
        return "admin-objects";
    }

    @PostMapping("/admin/objects/create")
    public String createObject(@RequestParam("file1") MultipartFile file1,
                               @RequestParam("file2") MultipartFile file2,
                               @RequestParam("file3") MultipartFile file3,
                               @RequestParam("file4") MultipartFile file4,
                               @RequestParam("file5") MultipartFile file5,
                               @RequestParam("file6") MultipartFile file6,
                               @RequestParam("file7") MultipartFile file7,
                               @RequestParam("file8") MultipartFile file8,
                               @RequestParam("file9") MultipartFile file9,
                               @RequestParam("file10") MultipartFile file10,
                               ObjectEntity objectEntity) throws IOException {
            objectService.saveObject(objectEntity, file1, file2, file3, file4, file5,
                    file6, file7, file8, file9, file10);
        return "redirect:/admin/objects";
    }
}
