package com.riwi.H2.service;

import com.riwi.H2.dto.VenueDTO;
import com.riwi.H2.model.entity.VenueEntity;
import com.riwi.H2.repository.VenueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<VenueEntity> getAll() {
        return venueRepository.findAll();
    }

    @Override
    public VenueEntity getById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venue no encontrado"));
    }

    @Override
    public VenueEntity create(VenueDTO venueDTO) {
        if (venueDTO.getName() == null || venueDTO.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del venue es obligatorio");
        }
        if (venueDTO.getLocation() == null || venueDTO.getLocation().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La ubicación del venue es obligatoria");
        }
        if (venueDTO.getCapacity() == null || venueDTO.getCapacity() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La capacidad debe ser un número positivo");
        }

        VenueEntity venue = new VenueEntity(null, venueDTO.getName(), venueDTO.getLocation(), venueDTO.getCapacity());
        return venueRepository.save(venue);
    }

    @Override
    public VenueEntity update(Long id, VenueDTO venueDTO) {
        venueRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venue no encontrado"));

        VenueEntity updated = new VenueEntity(id, venueDTO.getName(), venueDTO.getLocation(), venueDTO.getCapacity());

        return venueRepository.update(id, updated)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venue no encontrado"));
    }

    @Override
    public void delete(Long id) {
        venueRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venue no encontrado"));

        venueRepository.delete(id);
    }
}
