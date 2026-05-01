package com.ridebooking.payment.listener;

import com.ridebooking.payment.event.RideEvent;
import com.ridebooking.payment.service.interfaces.IPaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RideEventListener {

    private final IPaymentService paymentService;

    public RideEventListener(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "ride-events", groupId = "payment-service")
    public void onRideEvent(RideEvent event) {
        paymentService.handleRideEvent(event);
    }
}
