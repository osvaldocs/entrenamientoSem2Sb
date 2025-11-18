package com.riwi.H2.service;

import com.riwi.H2.dto.VenueDTO;
import com.riwi.H2.model.entity.VenueEntity;
import java.util.List;

public interface VenueService {
    List<VenueEntity> getAll();
    VenueEntity getById(Long id);
    VenueEntity create(VenueDTO venueDTO);
    VenueEntity update(Long id, VenueDTO venueDTO);
    void delete(Long id);
}
