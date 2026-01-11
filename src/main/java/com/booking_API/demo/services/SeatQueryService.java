package com.booking_API.demo.services;

import com.booking_API.demo.dto.BookingStatus;
import com.booking_API.demo.dto.Seat;
import com.booking_API.demo.dto.SeatResponse;
import com.booking_API.demo.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SeatQueryService {

    private final SeatRepository seatRepository;


    public SeatQueryService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<SeatResponse> getSeatsForEvent(Long eventId) {

        return seatRepository.findByEventId(eventId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private SeatResponse toResponse(Seat seat) {
        SeatResponse dto = new SeatResponse();
        dto.setSeatId(seat.getId());
        dto.setSeatNumber(seat.getSeatNumber());
        dto.setStatus(seat.getStatus()); // enum → JSON safe
        return dto;
    }
}
