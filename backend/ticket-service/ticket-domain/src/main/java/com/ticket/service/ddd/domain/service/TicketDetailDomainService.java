package com.ticket.service.ddd.domain.service;

import com.ticket.service.ddd.domain.model.entity.TicketDetail;

public interface TicketDetailDomainService {
    TicketDetail getTicketDetailById(Long ticketId);
}
