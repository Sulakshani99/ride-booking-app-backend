package com.ridebooking.shared.dto;

import com.ridebooking.shared.enums.PaymentMethod;
import com.ridebooking.shared.enums.RideStatus;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Shared RideEvent DTO for Kafka messaging across ride-booking services.
 */
public record RideEvent(
        String eventType,
        Long rideId,
        Long passengerId,
        Long driverId,
        PaymentMethod paymentMethod,
        RideStatus status,
        BigDecimal fare,
        Instant occurredAt
) {}
