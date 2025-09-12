package net.nrmmo.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ResponseDto(
        @JsonProperty("message")
        String message
) {
}
