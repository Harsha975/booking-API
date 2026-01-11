package com.booking_API.demo.services;

import com.booking_API.demo.dto.Event;
import com.booking_API.demo.dto.EventResponse;
import com.booking_API.demo.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EventQueryService {

    private final EventRepository eventRepository;

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
        dto.setEventId(event.getId());
        dto.setMovieName(event.getMovieName());
        dto.setStartTime(event.getStartTime());
        return dto;
    }

}
