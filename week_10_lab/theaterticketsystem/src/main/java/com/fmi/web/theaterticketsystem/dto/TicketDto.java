package com.fmi.web.theaterticketsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TicketDto {
    private Long ticketId;
    private BigDecimal price;
    private int row;
    private int seat;

    private UserDto user;
    private EventDto event;

    public TicketDto() {
    }

    public TicketDto(Long ticketId, BigDecimal price, int row, int seat, UserDto user, EventDto event) {
        this.ticketId = ticketId;
        this.price = price;
        this.row = row;
        this.seat = seat;
        this.user = user;
        this.event = event;
    }
}
