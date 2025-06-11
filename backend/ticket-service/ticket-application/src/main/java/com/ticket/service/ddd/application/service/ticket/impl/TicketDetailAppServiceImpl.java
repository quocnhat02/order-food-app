package com.ticket.service.ddd.application.service.ticket.impl;

import com.ticket.service.ddd.application.model.TicketExampleDTO;
import com.ticket.service.ddd.application.service.ticket.TicketDetailAppService;
import org.springframework.stereotype.Service;

@Service
public class TicketDetailAppServiceImpl implements TicketDetailAppService {
    @Override
    public TicketExampleDTO getTicketExample() {
        return new TicketExampleDTO("GET TICKET DETAIL FROM APPLICATION");
    }
}
