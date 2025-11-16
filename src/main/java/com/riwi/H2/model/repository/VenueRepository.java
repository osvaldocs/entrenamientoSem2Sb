package com.riwi.H2.model.repository;

import com.riwi.H2.model.entity.Venue;
import java.util.List;
import java.util.Optional;

public interface VenueRepository {
    List<Venue> findAll();
    Optional<Venue> findById(Long id);
    Venue save(Venue venue);
    void deleteById(Long id);
}
