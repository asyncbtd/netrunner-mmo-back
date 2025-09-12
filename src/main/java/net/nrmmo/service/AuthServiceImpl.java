package net.nrmmo.service;

import lombok.RequiredArgsConstructor;
import net.nrmmo.core.error.http.UnprocessableEntityHttpException;
import net.nrmmo.core.model.Email;
import net.nrmmo.core.model.User;
import net.nrmmo.core.service.AuthService;
import net.nrmmo.core.storage.EmailStorage;
import net.nrmmo.core.storage.UserStorage;
import net.nrmmo.web.dto.RequestRegisterDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserStorage userStorage;
    private final EmailStorage emailStorage;

    @Override
    @Transactional
    public void register(RequestRegisterDto registerDto) {
        var username = registerDto.username();
        var emailAddress = registerDto.emailAddress();
        var passwordHash = passwordEncoder.encode(registerDto.password());

        if (userStorage.existsUsername(username)) {
            throw new UnprocessableEntityHttpException("Username: {%s} is already in use".formatted(username));
        }

        if (emailStorage.existsAddress(emailAddress)) {
            throw new UnprocessableEntityHttpException("Email Address: {%s} is already in use".formatted(emailAddress));
        }

        var email = emailStorage.save(Email.builder()
                .version(0)
                .address(emailAddress)
                .active(false)
                .build());

        userStorage.save(User.builder()
                .version(0)
                .username(username)
                .password(passwordHash)
                .balance(0L)
                .email(email)
                .active(false)
                .build());
    }
}
