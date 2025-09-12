package net.nrmmo.storage;

import lombok.RequiredArgsConstructor;
import net.nrmmo.core.MapperEntity;
import net.nrmmo.core.model.User;
import net.nrmmo.core.storage.UserStorage;
import net.nrmmo.storage.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStorageImpl implements UserStorage {

    private final UserRepository userRepository;
    private final MapperEntity mapper;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(mapper::map)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean existsUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null) != null;
    }

    @Override
    public User save(User user) {
        return mapper.map(userRepository.save(mapper.entity(user)));
    }
}
