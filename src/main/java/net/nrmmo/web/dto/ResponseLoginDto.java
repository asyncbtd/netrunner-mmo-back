package net.nrmmo.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ResponseLoginDto(
        @JsonProperty("token")
        String token,
        @JsonProperty("refresh_token")
        String refreshToken
) {
}
