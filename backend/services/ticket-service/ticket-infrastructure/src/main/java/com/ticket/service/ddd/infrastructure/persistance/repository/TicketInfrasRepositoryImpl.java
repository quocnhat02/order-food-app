package com.ticket.service.ddd.infrastructure.persistance.repository;

import com.ticket.service.ddd.domain.repository.TicketDomainRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TicketInfrasRepositoryImpl implements TicketDomainRepository {
    @Override
    public String getTickets() {
        return "get tickets Infrastructure";
    }
}
