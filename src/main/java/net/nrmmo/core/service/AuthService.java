package net.nrmmo.core.service;

import net.nrmmo.web.dto.RequestRegisterDto;

public interface AuthService {
    void register(RequestRegisterDto registerDto);
}
