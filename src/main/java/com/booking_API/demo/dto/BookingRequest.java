package com.booking_API.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequest {
    private Long eventId;
    private List<Long> seatIds;
    private Long userId;
}
