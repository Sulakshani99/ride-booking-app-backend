package com.ridebooking.payment.event;

import com.ridebooking.payment.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.Instant;

public record RideEvent(
        String eventType,
        Long rideId,
        Long passengerId,
        Long driverId,
        PaymentMethod paymentMethod,
        String status,
        BigDecimal fare,
        Instant occurredAt
) {}
