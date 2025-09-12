package net.nrmmo.core.model;

import lombok.Builder;

@Builder
public record Email(
        Long id,
        Integer version,
        String address,
        boolean active
) {
}
