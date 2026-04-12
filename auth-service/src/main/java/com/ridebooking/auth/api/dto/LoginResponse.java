package com.ridebooking.auth.api.dto;

public record LoginResponse(
        String tokenType,
        String accessToken,
        String refreshToken,
        String role,
        String provider
) {
}
