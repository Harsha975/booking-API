package com.booking_API.demo.controller;

import com.booking_API.demo.dto.SeatResponse;
import com.booking_API.demo.services.SeatQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<SeatResponse> getSeats(@PathVariable Long eventId) {
        return seatQueryService.getSeatsForEvent(eventId);
    }
}
