package com.ticket.service.ddd.controller.http;

import com.ticket.service.ddd.application.service.event.EventApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TicketController {
    @Autowired
    private EventApplicationService eventApplicationService;

    @GetMapping("/tickets")
    public String getTickets(){
        return eventApplicationService.getTickets();
    }

}
