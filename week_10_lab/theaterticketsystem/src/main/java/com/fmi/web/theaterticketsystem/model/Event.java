package com.fmi.web.theaterticketsystem.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false)
  private LocalDateTime date;

  @Column
  private String description;

  @OneToMany
  private List<Ticket> tickets;

  @ManyToMany(mappedBy = "events")
  private List<Performer> performers;

  public Event() {
  }

  public Event(final String name, final LocalDateTime date, final String description) {
    this.name = name;
    this.date = date;
    this.description = description;
  }

  public Long getEventId() {
    return id;
  }

  public void setEventId(final Long eventId) {
    this.id = eventId;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(final LocalDateTime date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Event event = (Event)o;
    return id.equals(event.id) && name.equals(event.name) && Objects.equals(date, event.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, date);
  }

  @Override
  public String toString() {
    return "Event{" +
           "eventId=" + id +
           ", name='" + name + '\'' +
           ", date=" + date +
           ", description='" + description + '\'' +
           '}';
  }
}
