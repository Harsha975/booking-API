package com.booking_API.demo.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "event_Id")
    private Long eventId;

    @Column(name = "movie_name" , nullable = false)
    private String movieName;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime start_time;

    public Long getId() {
        return eventId;
    }

    public LocalDateTime getStartTime() {
        return start_time;
    }

    public String getMovieName() {
        return movieName;
    }
}
