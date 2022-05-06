package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
  List<Ticket> findAll();
}
