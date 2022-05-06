package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Performer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformerRepository {
    List<Performer> findAll();
}
