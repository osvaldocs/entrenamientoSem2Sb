package com.riwi.H2.model.repository;

import com.riwi.H2.model.entity.Event;
import java.util.List;
import java.util.Optional;

public interface EventRepository {
    List<Event> findAll();
    Optional<Event> findById(Long id);
    Event save(Event event);
    void deleteById(Long id);
}
