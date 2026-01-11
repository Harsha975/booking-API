package com.booking_API.demo.kafka;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class BookingIntentMessage {
    private UUID bookingId;
    private Long eventId;
    private Long userId;
    private List<Long> seatIds;
}
