package com.fmi.web.theaterticketsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Performer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String stage_name;

    @Column
    private Integer stageAge;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "event_performer",
    joinColumns = { @JoinColumn(name = "performer_id") },
    inverseJoinColumns = { @JoinColumn(name = "event_id") })
    private List<Event> events;
}
