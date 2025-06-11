package com.ticket.service.ddd.domain.service.impl;

import com.ticket.service.ddd.domain.model.entity.TicketDetail;
import com.ticket.service.ddd.domain.service.TicketDetailDomainService;
import org.springframework.stereotype.Service;

@Service
public class TicketDetailDomainServiceImpl implements TicketDetailDomainService {
    @Override
    public TicketDetail getTicketDetailById(Long ticketId) {
        return new TicketDetail("This is TICKET DOMAIN" + ticketId);
    }
}
