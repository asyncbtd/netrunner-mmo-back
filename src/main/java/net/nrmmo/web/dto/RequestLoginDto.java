package net.nrmmo.web.dto;

import lombok.Builder;

@Builder
public record RequestLoginDto(
        String username,
        String password
) {
}
