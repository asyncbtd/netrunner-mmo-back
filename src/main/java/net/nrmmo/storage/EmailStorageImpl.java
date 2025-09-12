package net.nrmmo.storage;

import lombok.RequiredArgsConstructor;
import net.nrmmo.core.MapperEntity;
import net.nrmmo.core.model.Email;
import net.nrmmo.core.storage.EmailStorage;
import net.nrmmo.storage.repository.EmailRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailStorageImpl implements EmailStorage {

    private final EmailRepository emailRepository;
    private final MapperEntity mapper;

    @Override
    public boolean existsAddress(String address) {
        return emailRepository.findByAddress(address)
                .orElse(null) != null;
    }

    @Override
    public Email save(Email email) {
        return mapper.map(emailRepository.save(mapper.entity(email)));
    }
}
