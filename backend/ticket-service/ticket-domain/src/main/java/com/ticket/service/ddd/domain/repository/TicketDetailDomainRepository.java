package com.ticket.service.ddd.domain.repository;

import com.ticket.service.ddd.domain.model.entity.TicketDetail;

import java.util.Optional;

public interface TicketDetailDomainRepository {
    TicketDetail findById(Long id);
}
