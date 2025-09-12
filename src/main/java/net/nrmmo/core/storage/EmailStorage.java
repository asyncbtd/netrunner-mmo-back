package net.nrmmo.core.storage;

import net.nrmmo.core.model.Email;

public interface EmailStorage {
    boolean existsAddress(String address);
    Email save(Email email);
}
