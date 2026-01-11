package com.booking_API.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventResponse {
    private Long eventId;
    private String movieName;
    private LocalDateTime startTime;
}
