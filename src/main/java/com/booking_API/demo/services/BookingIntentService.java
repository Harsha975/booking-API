package com.booking_API.demo.services;

import com.booking_API.demo.dto.BookingRequest;
import com.booking_API.demo.kafka.BookingIntentMessage;
import com.booking_API.demo.kafka.BookingIntentProducer;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Service
public class BookingIntentService {


    private final BookingIntentProducer producer;

    public BookingIntentService(BookingIntentProducer producer)
    {
        this.producer = producer;
    }


    public String createBookingIntent(BookingRequest request) {

        String bookingId = UUID.randomUUID().toString();

        BookingIntentMessage message = new BookingIntentMessage();
        message.setBookingId(UUID.fromString(bookingId));
        message.setEventId(request.getEventId());
        message.setSeatIds(request.getSeatIds());
        message.setUserId(request.getUserId());

        producer.send(message);

        return bookingId;
    }
}
