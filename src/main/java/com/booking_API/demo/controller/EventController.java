package com.booking_API.demo.controller;

import com.booking_API.demo.dto.EventResponse;
import com.booking_API.demo.services.EventQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
