package com.booking_API.demo.controller;

import com.booking_API.demo.dto.Seat;
import com.booking_API.demo.dto.SeatResponse;
import com.booking_API.demo.services.SeatQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events/{eventId}/seats")
public class SeatController {
    private  final SeatQueryService seatQueryService;


    public SeatController(SeatQueryService seatQueryService) {
        this.seatQueryService = seatQueryService;
    }

    /**
     * Get seat layout for an event
     */
    @GetMapping
    public List<SeatResponse> getSeats(@PathVariable("eventId") Long eventId) {
        return seatQueryService.getSeatsForEvent(eventId);
    }

    @PostMapping("/createSeats")
    public ResponseEntity<?> createSeats(@RequestBody List<Seat> seat){
        return new ResponseEntity<>(seatQueryService.createSeat(seat) , HttpStatus.CREATED);
    }
}
