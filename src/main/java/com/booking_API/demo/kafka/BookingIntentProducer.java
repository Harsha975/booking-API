package com.booking_API.demo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingIntentProducer {
    private final KafkaTemplate<String, BookingIntentMessage> kafkaTemplate;


    public BookingIntentProducer(KafkaTemplate<String, BookingIntentMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(BookingIntentMessage message) {
        kafkaTemplate.send(
                "booking-intents",
                String.valueOf(message.getBookingId()),
                message
        );
    }
}
