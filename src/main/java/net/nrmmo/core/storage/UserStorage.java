package net.nrmmo.core.storage;

import net.nrmmo.core.model.User;

public interface UserStorage {
    User findByUsername(String username);
    boolean existsUsername(String username);
    User save(User user);
}
