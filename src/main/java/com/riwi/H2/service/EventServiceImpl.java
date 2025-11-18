package com.riwi.H2.service;

import com.riwi.H2.dto.EventDTO;
import com.riwi.H2.model.entity.EventEntity;
import com.riwi.H2.model.entity.VenueEntity;
import com.riwi.H2.repository.EventRepository;
import com.riwi.H2.repository.VenueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    public EventServiceImpl(EventRepository eventRepository, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }

    @Override
    public List<EventEntity> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public EventEntity getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado"));
    }

    @Override
    public EventEntity create(EventDTO eventDTO) {

        if (eventDTO.getName() == null || eventDTO.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del evento es obligatorio");
        }
        if (eventDTO.getDate() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha del evento es obligatoria");
        }
        if (eventDTO.getVenueId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El venueId es obligatorio");
        }

        // Convertir String -> LocalDate
        LocalDate date;
        try {
            date = LocalDate.parse(eventDTO.getDate());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de fecha inválido. Use YYYY-MM-DD");
        }

        // Buscar el venue
        VenueEntity venue = venueRepository.findById(eventDTO.getVenueId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "El venue no existe"));

        EventEntity event = new EventEntity(null, eventDTO.getName(), date, venue);
        return eventRepository.save(event);
    }

    @Override
    public EventEntity update(Long id, EventDTO eventDTO) {

        eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado"));

        if (eventDTO.getName() == null || eventDTO.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del evento es obligatorio");
        }

        // Convertir String → LocalDate
        LocalDate date;
        try {
            date = LocalDate.parse(eventDTO.getDate());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de fecha inválido. Use YYYY-MM-DD");
        }

        // Buscar venue
        VenueEntity venue = venueRepository.findById(eventDTO.getVenueId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "El venue no existe"));

        EventEntity updated = new EventEntity(id, eventDTO.getName(), date, venue);

        return eventRepository.update(id, updated)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado"));
    }

    @Override
    public void delete(Long id) {
        eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado"));
        eventRepository.delete(id);
    }
}
