package com.riwi.H2.repository;

import com.riwi.H2.model.entity.Event;
import java.util.List;

public interface EventRepository {
    List<Event> findAll();
    Event findById(Long id);
    Event save(Event event);
    Event update(Long id, Event event);
    void delete(Long id);
}
