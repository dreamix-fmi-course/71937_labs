package com.fmi.web.theaterticketsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long ticketId;
  @Column
  private BigDecimal price;
  @Column
  private int row;
  @Column
  private int seat;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_account_id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "event_id", nullable = false)
  private Event event;

  public Ticket() {
  }

  public Ticket(BigDecimal price, int row, int seat, User user, Event event) {
    this.price = price;
    this.row = row;
    this.seat = seat;
    this.user = user;
    this.event = event;
  }
}
