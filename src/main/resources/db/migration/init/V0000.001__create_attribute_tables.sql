create table attribute_schema.emails_attrs
(
    instance_attr_id  bigint generated always as identity,
    instance_id       bigint not null,
    attr_id           bigint not null,
    attr_as_bool      boolean,
    attr_as_float     numeric(20, 4),
    attr_as_string    varchar(2040),
    attr_as_timestamp timestamp,
    constraint pk_emails_attrs_iaid
        primary key (instance_attr_id),
    constraint fk_emails_attrs_iid
        foreign key (instance_id) references nrmmo_schema.emails (email_id)
            on update cascade
            on delete cascade,
    constraint fk_emails_attrs_aid
        foreign key (attr_id) references reference_schema.ref_attrs (attr_id)
            on update cascade
            on delete cascade,
    constraint uk_emails_attrs_iid_aid
        unique (instance_id, attr_id)
);

alter table attribute_schema.emails_attrs
    owner to nrmmo;

create table attribute_schema.users_attrs
(
    instance_attr_id  bigint generated always as identity,
    instance_id       bigint not null,
    attr_id           bigint not null,
    attr_as_bool      boolean,
    attr_as_float     numeric(20, 4),
    attr_as_string    varchar(2040),
    attr_as_timestamp timestamp,
    constraint pk_users_attrs_iaid
        primary key (instance_attr_id),
    constraint fk_users_attrs_iid
        foreign key (instance_id) references nrmmo_schema.users (user_id)
            on update cascade
            on delete cascade,
    constraint fk_users_attrs_aid
        foreign key (attr_id) references reference_schema.ref_attrs (attr_id)
            on update cascade
            on delete cascade,
    constraint uk_users_attrs_iid_aid
        unique (instance_id, attr_id)
);

alter table attribute_schema.users_attrs
    owner to nrmmo;
