package com.ticket.service.ddd.application.mapper;

import com.ticket.service.ddd.application.model.TicketDetailDTO;
import com.ticket.service.ddd.domain.model.entity.TicketDetail;
import org.springframework.beans.BeanUtils;

public class TicketDetailMapper {
    public static TicketDetailDTO mapperToTicketDetailDTO(TicketDetail ticketDetail) {
        if(ticketDetail == null) return null;

        TicketDetailDTO ticketDetailDTO = new TicketDetailDTO();
        BeanUtils.copyProperties(ticketDetail, ticketDetailDTO);

        return ticketDetailDTO;
    }
}
