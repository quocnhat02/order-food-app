package com.ticket.service.ddd.controller.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HiController {
    @GetMapping("/hi")
    public String sayHi() {
        return "Hello";
    }
}
