package com.booking_API.demo.controller;

import com.booking_API.demo.dto.Event;
import com.booking_API.demo.dto.EventResponse;
import com.booking_API.demo.services.EventQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventQueryService eventQueryService;


    public EventController(EventQueryService eventQueryService) {
        this.eventQueryService = eventQueryService;
    }

    /**
     * Get all active events
     */
    @GetMapping
    public List<EventResponse> getActiveEvents() {
        return eventQueryService.getAllEvents();
    }

    /**
     * Get event details by ID
     */
    @GetMapping("/{eventId}")
    public EventResponse getEvent(@PathVariable Long eventId) {
        return eventQueryService.getEvent(eventId);
    }

    @PostMapping("/createEvent")
    public ResponseEntity<?>  createEvent(@RequestBody Event eventBody) {
        return new ResponseEntity<>(eventQueryService.createEvent(eventBody), HttpStatus.CREATED);
    }
}
