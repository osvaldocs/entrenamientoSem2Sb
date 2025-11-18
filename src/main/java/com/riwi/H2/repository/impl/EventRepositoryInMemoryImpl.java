package com.riwi.H2.repository.impl;

import com.riwi.H2.model.entity.EventEntity;
import com.riwi.H2.repository.EventRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("inmemory")
public class EventRepositoryInMemoryImpl implements EventRepository {

    private final Map<Long, EventEntity> events = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<EventEntity> findAll() {
        return new ArrayList<>(events.values());
    }

    @Override
    public Optional<EventEntity> findById(Long id) {
        return Optional.ofNullable(events.get(id));
    }

    @Override
    public EventEntity save(EventEntity event) {
        event.setId(nextId++);
        events.put(event.getId(), event);
        return event;
    }

    @Override
    public Optional<EventEntity> update(Long id, EventEntity event) {
        if (!events.containsKey(id)) {
            return Optional.empty();
        }

        event.setId(id);
        events.put(id, event);
        return Optional.of(event);
    }

    @Override
    public void delete(Long id) {
        events.remove(id);
    }
}
