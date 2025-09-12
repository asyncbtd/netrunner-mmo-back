package net.nrmmo.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record RequestRegisterDto(
        @JsonProperty("username")
        String username,
        @JsonProperty("email_address")
        String emailAddress,
        @JsonProperty("password")
        String password
) {
}
