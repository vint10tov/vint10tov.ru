package ru.v10tov.controllers.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ClientController {

    @GetMapping("/client")
    public String client() {
        return "client";
    }
}
