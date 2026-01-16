package com.booking_API.demo.services;

import com.booking_API.demo.dto.BookingStatus;
import com.booking_API.demo.dto.Seat;
import com.booking_API.demo.dto.SeatResponse;
import com.booking_API.demo.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SeatQueryService {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;

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

    public String createSeat(List<Seat> seat) {
        try{
            seatRepository.saveAll(seat);
        }
        catch (Exception e){
            return "Error creating seats" + e.getMessage();
        }
        return "Seats created for eventId"+ seat.getFirst().getEventId();
    }
}
