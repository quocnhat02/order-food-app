package com.ticket.service.ddd.domain.service.impl;

import com.ticket.service.ddd.domain.model.entity.TicketDetail;
import com.ticket.service.ddd.domain.repository.TicketDetailDomainRepository;
import com.ticket.service.ddd.domain.service.TicketDetailDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketDetailDomainServiceImpl implements TicketDetailDomainService {

    @Autowired
    private TicketDetailDomainRepository ticketDetailDomainRepository;

    @Override
    public TicketDetail getTicketDetailById(Long ticketId) {
        return ticketDetailDomainRepository.findById(ticketId);
    }
}
