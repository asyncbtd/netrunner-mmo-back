package net.nrmmo.web;

import lombok.RequiredArgsConstructor;
import net.nrmmo.core.service.AuthService;
import net.nrmmo.web.dto.RequestLoginDto;
import net.nrmmo.web.dto.RequestRegisterDto;
import net.nrmmo.web.dto.ResponseDto;
import net.nrmmo.web.dto.ResponseLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.nrmmo.config.Constants.Controller.AUTH_V1;

@RestController
@RequestMapping(AUTH_V1)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(
            @RequestBody RequestRegisterDto registerDto
    ) {
        authService.register(registerDto);
        return ResponseEntity.ok(new ResponseDto("user created successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDto> login(
            @RequestBody RequestLoginDto loginDto
    ) {
        return ResponseEntity.ok(new ResponseLoginDto("das", "das"));
    }
}
