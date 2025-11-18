package com.riwi.H2.service;

import com.riwi.H2.dto.EventDTO;
import com.riwi.H2.model.entity.EventEntity;
import java.util.List;

public interface EventService {
    List<EventEntity> getAll();
    EventEntity getById(Long id);
    EventEntity create(EventDTO eventDTO);
    EventEntity update(Long id, EventDTO eventDTO);
    void delete(Long id);
}
