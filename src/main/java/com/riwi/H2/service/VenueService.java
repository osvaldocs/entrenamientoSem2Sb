package com.riwi.H2.service;

import com.riwi.H2.dto.VenueDTO;
import com.riwi.H2.model.entity.Venue;
import java.util.List;

public interface VenueService {
    List<Venue> getAll();
    Venue getById(Long id);
    Venue create(VenueDTO venueDTO);
    Venue update(Long id, VenueDTO venueDTO);
    void delete(Long id);
}
