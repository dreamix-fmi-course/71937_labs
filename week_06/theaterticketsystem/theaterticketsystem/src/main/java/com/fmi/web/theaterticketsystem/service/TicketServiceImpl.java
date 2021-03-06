package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.config.AppConfig;
import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.model.Ticket;
import com.fmi.web.theaterticketsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    // ДОВЪРШИ ТОВА ВКЪЩИ :)

    @Autowired
    AppConfig appConfig;

    @Override
    public void createTicket(final Ticket u) throws Exception {
        if (u.getRow() > appConfig.getTicket().getRows()) {
            if (u.getSeat() > appConfig.getTicket().getCols()) {
                throw new Exception("Seats are full");
            } else {

            }
        } else {
            throw new Exception("Rows are full");
        }
    }

    @Override
    public void removeTicket(final Long id) {

    }

    @Override
    public Ticket findById(final Long id) {
        return null;
    }

    @Override
    public void updateTicketById(final Long id) {

    }

    @Override
    public List<Ticket> findAllTicketsByUser(final User id) {
        return null;
    }

    @Override
    public List<Ticket> findAllTicketByEvent(final Event event) {
        return null;
    }

    @Override
    public List<Event> findAllEventsBetweenDates(final LocalDate from, final LocalDate to) {
        return null;
    }
}
