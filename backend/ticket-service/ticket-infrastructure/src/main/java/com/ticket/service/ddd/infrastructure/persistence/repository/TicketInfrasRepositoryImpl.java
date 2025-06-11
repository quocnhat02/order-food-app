package com.ticket.service.ddd.infrastructure.persistence.repository;

import com.ticket.service.ddd.domain.model.entity.TicketDetail;
import com.ticket.service.ddd.domain.repository.TicketDetailDomainRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketInfrasRepositoryImpl implements TicketDetailDomainRepository {
    @Override
    public TicketDetail findById(Long id) {
        return new TicketDetail("Hello FROM INFRAS" + id);
    }
}
