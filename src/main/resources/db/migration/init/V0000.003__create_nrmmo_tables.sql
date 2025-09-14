create table nrmmo_schema.emails
(
    email_id      bigint generated always as identity,
    email_version integer default 0     not null,
    email_address varchar(254)          not null,
    email_active  boolean default false not null,
    constraint pk_emails_eid
        primary key (email_id),
    constraint chk_emails_ev
        check (email_version >= 0)
);

create table nrmmo_schema.users
(
    user_id       bigint generated always as identity,
    user_version  integer default 0     not null,
    user_name     varchar(255)          not null,
    user_password varchar(255)          not null,
    email_id      bigint                not null,
    user_active   boolean default false not null,
    constraint pk_users_uid
        primary key (user_id),
    constraint fk_users_eid
        foreign key (email_id)
            references nrmmo_schema.emails (email_id)
            on update cascade
            on delete no action,
    constraint chk_users_uv
        check (user_version >= 0)
);

-- TODO
create table nrmmo_schema.chats
(
    chat_id      bigint generated always as identity,
    chat_version integer default 0 not null,
    chat_type_id bigint            not null
);

create table nrmmo_schema.chat_users
(
    chat_id bigint not null,
    user_id bigint not null,
    constraint pk_chat_users_cid_uid
        primary key (chat_id, user_id),
    constraint fk_chat_users_cid
        foreign key (chat_id)
            references nrmmo_schema.chats (chat_id)
            on update cascade
            on delete cascade,
    constraint fk_chat_users_uid
        foreign key (user_id)
            references nrmmo_schema.users (user_id)
            on update cascade
            on delete cascade
);
