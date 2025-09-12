package net.nrmmo.core;

import net.nrmmo.core.model.Email;
import net.nrmmo.core.model.User;
import net.nrmmo.storage.entity.EmailEntity;
import net.nrmmo.storage.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class MapperEntity {

    public abstract Email map(EmailEntity entity);
    public abstract EmailEntity entity(Email email);

    @Mapping(target = "email", expression = "java(map(entity.getEmail()))")
    public abstract User map(UserEntity entity);

    @Mapping(target = "email", expression = "java(entity(user.email()))")
    public abstract UserEntity entity(User user);
}
