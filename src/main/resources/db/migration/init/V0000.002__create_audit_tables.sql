create table audit_schema.chat_messages
(
    chat_message_id        bigint generated always as identity,
    chat_message_version   integer default 0 not null,
    from_user_id           bigint            not null,
    chat_id                bigint,
    chat_message_text      varchar(1020)      not null,
    chat_message_timestamp timestamp         not null,
    constraint pk_chat_messages_cmid
        primary key (chat_message_id),
    constraint fk_chat_messages_fuid
        foreign key (from_user_id) references nrmmo_schema.users (user_id)
            on update cascade
            on delete no action,
    constraint fk_chat_messages_cid
        foreign key (chat_id) references reference_schema.ref_chats (chat_id)
            on update cascade
            on delete no action,
    constraint chk_chat_messages_cmv
        check (chat_message_version >= 0)
);

comment on table audit_schema.chat_messages
    is 'Таблица для хранения сообщений пользователей в глобальном и локальном чате';

comment on column audit_schema.chat_messages.chat_message_id
    is 'Идентификатор сообщения';

comment on column audit_schema.chat_messages.chat_message_version
    is 'Версия сообщения';

comment on column audit_schema.chat_messages.from_user_id
    is 'Идентификатор пользователя который отправил сообщение';

comment on column audit_schema.chat_messages.chat_id
    is 'Идентификатор чата к которому относиться сообщение';

comment on column audit_schema.chat_messages.chat_message_text
    is 'Текст сообщения';

comment on column audit_schema.chat_messages.chat_message_timestamp
    is 'Дата и время отправления сообщения';

alter table audit_schema.chat_messages
    owner to nrmmo;

create table audit_schema.logs
(
    log_id        bigint generated always as identity,
    log_version   integer default 0 not null,
    event_type_id bigint            not null,
    user_id       bigint,
    log_text      varchar(1020)     not null,
    log_timestamp timestamp         not null,
    constraint pk_logs_lid
        primary key (log_id),
    constraint fk_logs_etid
        foreign key (event_type_id) references reference_schema.ref_event_types (event_type_id)
            on update cascade
            on delete no action,
    constraint fk_logs_uid
        foreign key (user_id) references nrmmo_schema.users (user_id)
            on update cascade
            on delete no action,
    constraint chk_logs_lv
        check (log_version >= 0)
);

comment on table audit_schema.logs
    is 'Таблица для хранения событий';

comment on column audit_schema.logs.log_id
    is 'Идентификатор события';

comment on column audit_schema.logs.log_version
    is 'Версия события';

comment on column audit_schema.logs.event_type_id
    is 'Идентификатор типа события';

comment on column audit_schema.logs.user_id
    is 'Идентификатор пользователя системы вызвавшего событие';

comment on column audit_schema.logs.log_text
    is 'Сообщение события';

comment on column audit_schema.logs.log_timestamp
    is 'Дата и время события';

alter table audit_schema.logs
    owner to nrmmo;
