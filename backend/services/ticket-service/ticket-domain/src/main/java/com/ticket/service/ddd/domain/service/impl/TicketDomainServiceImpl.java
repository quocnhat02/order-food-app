package com.ticket.service.ddd.domain.service.impl;

import com.ticket.service.ddd.domain.repository.TicketDomainRepository;
import com.ticket.service.ddd.domain.service.TicketDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketDomainServiceImpl implements TicketDomainService {

    @Autowired
    private TicketDomainRepository ticketDomainRepository;

    @Override
    public String getTickets() {
        return ticketDomainRepository.getTickets();
    }
}
