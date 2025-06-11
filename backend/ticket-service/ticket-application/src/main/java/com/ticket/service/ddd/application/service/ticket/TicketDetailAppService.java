package com.ticket.service.ddd.application.service.ticket;

import com.ticket.service.ddd.application.model.TicketDetailDTO;

public interface TicketDetailAppService {
    TicketDetailDTO getTicketDetailById(Long ticketId, Long version); // should convert to TickDetailDTO by Application Module
    // order ticket
    boolean orderTicketByUser(Long ticketId);
}
