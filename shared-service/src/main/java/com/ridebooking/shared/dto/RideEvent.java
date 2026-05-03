package com.ridebooking.shared.dto;

import com.ridebooking.shared.enums.PaymentMethod;
import com.ridebooking.shared.enums.RideStatus;
import java.math.BigDecimal;
import java.time.Instant;

public record RideEvent(
        String eventType,
        Long rideId,
        Long passengerId,
        String passengerEmail,
        Long driverId,
        String driverEmail,
        PaymentMethod paymentMethod,
        RideStatus status,
        BigDecimal fare,
        Instant occurredAt
) {}
