package com.ridebooking.ride.event;

import com.ridebooking.ride.enums.RideStatus;

import java.math.BigDecimal;
import java.time.Instant;

public record RideEvent(
        String eventType,
        Long rideId,
        Long passengerId,
        Long driverId,
        RideStatus status,
        BigDecimal fare,
        Instant occurredAt
) {}
