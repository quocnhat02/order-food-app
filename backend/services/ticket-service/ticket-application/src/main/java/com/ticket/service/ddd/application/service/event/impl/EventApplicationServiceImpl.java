package com.ticket.service.ddd.application.service.event.impl;

import com.ticket.service.ddd.application.service.event.EventApplicationService;
import com.ticket.service.ddd.domain.service.TicketDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventApplicationServiceImpl implements EventApplicationService {
   // Call domain service
    @Autowired
    private TicketDomainService ticketDomainService;

    @Override
    public String getTickets() {
        return ticketDomainService.getTickets();
    }
}
