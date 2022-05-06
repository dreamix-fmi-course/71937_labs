package com.fmi.web.theaterticketsystem.controller;

import com.fmi.web.theaterticketsystem.dto.TicketDto;
import com.fmi.web.theaterticketsystem.mapper.TicketDtoMapper;
import com.fmi.web.theaterticketsystem.model.Ticket;
import com.fmi.web.theaterticketsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    private TicketDtoMapper ticketDtoMapper;

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketDtoMapper ticketDtoMapper, TicketService ticketService) {
        this.ticketDtoMapper = ticketDtoMapper;
        this.ticketService = ticketService;
    }

    @PostMapping
    public TicketDto createTicket(@RequestBody TicketDto dto) {
        Ticket ticket = ticketDtoMapper.convertToEntity(dto);
        ticket = ticketService.createTicket(ticket);
        return ticketDtoMapper.convertToDto(ticket);
    }

    @RequestMapping("{userId}")
    public List<Ticket> findTickets(@PathVariable Long userId) {
        return null;
    }
}
