package com.riwi.H2.repository;

import com.riwi.H2.model.entity.Venue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VenueRepositoryImpl implements VenueRepository {

    private final List<Venue> venues = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Venue> findAll() {
        return venues;
    }

    @Override
    public Venue findById(Long id) {
        return venues.stream()
                .filter(venue -> venue.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Venue save(Venue venue) {
        venue.setId(nextId++);
        venues.add(venue);
        return venue;
    }

    @Override
    public Venue update(Long id, Venue venue) {
        Venue existing = findById(id);
        if (existing != null) {
            existing.setName(venue.getName());
            existing.setLocation(venue.getLocation());
            existing.setCapacity(venue.getCapacity());
        }
        return existing;
    }

    @Override
    public void delete(Long id) {
        venues.removeIf(venue -> venue.getId().equals(id));
    }
}
