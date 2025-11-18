package com.riwi.H2.mapper;

import com.riwi.H2.dto.EventDTO;
import com.riwi.H2.dto.VenueDTO;
import com.riwi.H2.model.entity.EventEntity;
import com.riwi.H2.model.entity.VenueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventVenueMapper {

    EventVenueMapper INSTANCE = Mappers.getMapper(EventVenueMapper.class);

    // ---------------- Event ----------------
    @Mapping(source = "venue.id", target = "venueId")
    @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd")
    EventDTO eventToEventDTO(EventEntity event);

    @Mapping(source = "venueId", target = "venue.id")
    @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd")
    EventEntity eventDTOToEvent(EventDTO eventDTO);

    // ---------------- Venue ----------------
    VenueDTO venueToVenueDTO(VenueEntity venue);

    VenueEntity venueDTOToVenue(VenueDTO venueDTO);
}
