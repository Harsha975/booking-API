package com.booking_API.demo.repository;

import com.booking_API.demo.dto.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
