package com.riwi.H2.repository;

import com.riwi.H2.model.entity.VenueEntity;
import java.util.List;
import java.util.Optional;


public interface VenueRepository {
    List<VenueEntity> findAll();
    Optional<VenueEntity> findById(Long id);
    VenueEntity save(VenueEntity venue);
    Optional<VenueEntity> update(Long id, VenueEntity venue);
    void delete(Long id);
}
