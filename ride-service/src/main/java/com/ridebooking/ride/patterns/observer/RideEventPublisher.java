package com.ridebooking.ride.patterns.observer;

import com.ridebooking.ride.entity.Ride;
import com.ridebooking.shared.dto.RideEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class RideEventPublisher {

    @Value("${spring.kafka.template.default-topic}")
    private String topic;
    
    private final KafkaTemplate<String, RideEvent> kafkaTemplate;

    public RideEventPublisher(KafkaTemplate<String, RideEvent> kafkaTemplate) 
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String eventType, Ride ride) 
    {
        RideEvent event = new RideEvent(
                eventType,
                ride.getId(),
                ride.getPassengerId(),
                ride.getPassengerEmail(),
                ride.getDriverId(),
                ride.getDriverEmail(),
                ride.getPaymentMethod(),
                ride.getStatus(),
                ride.getFinalFare() != null ? ride.getFinalFare() : ride.getEstimatedFare(),
                Instant.now()
        );
        kafkaTemplate.send(topic, ride.getId().toString(), event);
    }
}
