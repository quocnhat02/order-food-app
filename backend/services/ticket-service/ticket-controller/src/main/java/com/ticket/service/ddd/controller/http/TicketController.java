package com.ticket.service.ddd.controller.http;

import com.ticket.service.ddd.application.service.event.EventApplicationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
    @RateLimiter(name = "getTickets", fallbackMethod = "fallbackTicket")
    @CircuitBreaker(name = "getTickets", fallbackMethod = "fallbackCircuitBreaker")
    public String getTickets(){
        return eventApplicationService.getTickets();
    }

    public String fallbackTicket(Throwable throwable) {
        return "Too many request";
    }

    public String fallbackCircuitBreaker(Throwable throwable) {
        return "Ticket Service Error";
    }

    @GetMapping("/tickets2")
    @RateLimiter(name = "backendB", fallbackMethod = "fallbackTicket")
    public String getTickets2(){
        return eventApplicationService.getTickets();
    }

}
