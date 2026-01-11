package com.booking_API.demo.dto;

import lombok.Data;

@Data
public class SeatResponse {
    private Long seatId;
    private Long seatNumber;
    private BookingStatus status;
}
