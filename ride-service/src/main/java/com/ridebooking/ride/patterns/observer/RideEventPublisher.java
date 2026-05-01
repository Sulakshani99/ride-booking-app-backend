package com.ridebooking.ride.patterns.observer;

import com.ridebooking.ride.entity.Ride;
import com.ridebooking.ride.event.RideEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class RideEventPublisher {

    private static final String TOPIC = "ride-events";
    private final KafkaTemplate<String, RideEvent> kafkaTemplate;

    public RideEventPublisher(KafkaTemplate<String, RideEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String eventType, Ride ride) {
        RideEvent event = new RideEvent(
                eventType,
                ride.getId(),
                ride.getPassengerId(),
                ride.getDriverId(),
            ride.getPaymentMethod(),
                ride.getStatus(),
                ride.getFinalFare() != null ? ride.getFinalFare() : ride.getEstimatedFare(),
                Instant.now()
        );
        kafkaTemplate.send(TOPIC, ride.getId().toString(), event);
    }
}
