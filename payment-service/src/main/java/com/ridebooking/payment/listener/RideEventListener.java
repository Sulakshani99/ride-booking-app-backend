package com.ridebooking.payment.listener;

import com.ridebooking.shared.dto.RideEvent;
import com.ridebooking.payment.service.interfaces.IPaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RideEventListener {

    private final IPaymentService paymentService;

    public RideEventListener(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(
        topics = "${spring.kafka.template.default-topic}",
        groupId = "${spring.kafka.consumer.group-id}"
    )
    public void onRideEvent(RideEvent event) 
    {
        paymentService.handleRideEvent(event);
    }
}
