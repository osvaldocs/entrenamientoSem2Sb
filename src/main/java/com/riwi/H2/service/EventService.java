package com.riwi.H2.service;

import com.riwi.H2.dto.EventDTO;
import com.riwi.H2.model.entity.Event;
import java.util.List;

public interface EventService {
    List<Event> getAll();
    Event getById(Long id);
    Event create(EventDTO eventDTO);
    Event update(Long id, EventDTO eventDTO);
    void delete(Long id);
}
