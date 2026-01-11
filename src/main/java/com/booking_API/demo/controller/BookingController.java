package com.booking_API.demo.controller;

import com.booking_API.demo.dto.BookingRequest;
import com.booking_API.demo.services.BookingIntentService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingIntentService bookingIntentService;

    public BookingController(BookingIntentService bookingIntentService) {
        this.bookingIntentService = bookingIntentService;
    }

    /**
     * Create booking intent (ASYNC)
     */
    @PostMapping
    public ResponseEntity<String> createBooking(
            @RequestBody BookingRequest request) {

        bookingIntentService.createBookingIntent(request);
        return ResponseEntity.accepted().body("Booking request accepted");
    }
}
