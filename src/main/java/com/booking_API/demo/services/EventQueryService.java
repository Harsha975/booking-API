package com.booking_API.demo.services;

import com.booking_API.demo.dto.Event;
import com.booking_API.demo.dto.EventResponse;
import com.booking_API.demo.repository.EventRepository;
import com.sun.jdi.request.EventRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Transactional
public class EventQueryService {

    private final EventRepository eventRepository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;

    public EventQueryService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventResponse> getAllEvents(){
        return eventRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public EventResponse getEvent(Long eventId){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event Not found"));

        return toResponse(event);
    }

    private EventResponse toResponse(Event event){
        EventResponse dto = new EventResponse();
        dto.setEventId(event.getEventId());
        dto.setMovieName(event.getMovieName());
        dto.setStartTime(event.getStart_time());
        return dto;
    }

    @Transactional
    public String createEvent(Event eventRequest) {
        try {
            eventRepository.save(eventRequest);
            return "Event Created with eventID " + eventRequest.getEventId();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e; // 🔥 IMPORTANT
        }
    }
}
