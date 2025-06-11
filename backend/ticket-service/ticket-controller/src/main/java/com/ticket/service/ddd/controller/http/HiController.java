package com.ticket.service.ddd.controller.http;

import com.ticket.service.ddd.application.model.TicketDetailDTO;
import com.ticket.service.ddd.application.service.ticket.TicketDetailAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HiController {

    @Autowired
    private TicketDetailAppService ticketDetailAppService;

    @GetMapping("/hi")
    public TicketDetailDTO sayHi() {
        return ticketDetailAppService.getTicketDetailById(10L, 10L);
    }
}
