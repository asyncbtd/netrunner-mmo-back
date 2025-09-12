package net.nrmmo.service;

import lombok.RequiredArgsConstructor;
import net.nrmmo.core.service.UserService;
import net.nrmmo.core.storage.UserStorage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserStorage userStorage;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userStorage.findByUsername(username);
    }
}
