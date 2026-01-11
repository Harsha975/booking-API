package com.booking_API.demo.dto;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "seats")
@IdClass(SeatId.class)
public class Seat {
    @Id
    @Column(name = "seat_id")
    private Long seatId;
    @Id
    @Column(name = "event_id")
    private Long eventId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus status;

    @Column(name = "locked_at")
    private LocalDateTime lockedAt;

    @Column(name = "locked_by")
    private Long lockedBy;

    public Long getId() {
        return seatId;
    }

    public Long getSeatNumber() {
        return seatId;
    }
}
