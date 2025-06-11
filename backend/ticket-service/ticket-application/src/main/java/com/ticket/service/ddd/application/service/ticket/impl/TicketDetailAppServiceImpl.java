package com.ticket.service.ddd.application.service.ticket.impl;

import com.ticket.service.ddd.application.mapper.TicketDetailMapper;
import com.ticket.service.ddd.application.model.TicketDetailDTO;
import com.ticket.service.ddd.application.service.ticket.TicketDetailAppService;
import com.ticket.service.ddd.domain.service.TicketDetailDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketDetailAppServiceImpl implements TicketDetailAppService {
    @Autowired
    private TicketDetailDomainService ticketDetailDomainService;

    @Override
    public TicketDetailDTO getTicketDetailById(Long ticketId, Long version) {
        return TicketDetailMapper.mapperToTicketDetailDTO(ticketDetailDomainService.getTicketDetailById(ticketId));
    }

    @Override
    public boolean orderTicketByUser(Long ticketId) {
        return false;
    }
}
