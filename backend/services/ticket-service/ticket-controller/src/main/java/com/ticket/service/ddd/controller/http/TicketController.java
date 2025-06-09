package com.ticket.service.ddd.controller.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TicketController {

    @GetMapping("/tickets")
    public String getTickets(){
        return "All tickets";
    }

}
