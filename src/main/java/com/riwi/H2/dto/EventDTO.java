package com.riwi.H2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private String name;
    private String date;      // String -> LocalDate dentro del Service
    private Long venueId;     // String -> Long para buscar el venue
}
