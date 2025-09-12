create table reference_schema.ref_countries
(
    country_id            bigint generated always as identity,
    country_version       integer default 0    not null,
    country_name          varchar(255)         not null,
    country_official_name varchar(255)         not null,
    country_iso2          varchar(2)           not null,
    country_iso3          varchar(3)           not null,
    country_code          varchar(3)           not null,
    country_active        boolean default true not null,
    constraint pk_ref_countries_cid
        primary key (country_id),
    constraint chk_ref_countries_cv
        check (country_version >= 0)
);

comment on table reference_schema.ref_countries
    is 'Таблица для хранения справочника стран согласно стандарту ISO 3166-1';

comment on column reference_schema.ref_countries.country_id
    is 'Идентификатор страны';

comment on column reference_schema.ref_countries.country_name
    is 'Наименование страны';

comment on column reference_schema.ref_countries.country_official_name
    is 'Официальное наименование страны';

comment on column reference_schema.ref_countries.country_iso2
    is 'Код страны согласно стандарту ISO 3166-1 Alpha-2';

comment on column reference_schema.ref_countries.country_iso3
    is 'Код страны согласно стандарту ISO 3166-1 Alpha-3';

comment on column reference_schema.ref_countries.country_code
    is 'Цифровой код страны согласно стандарту ISO 3166-1';

comment on column reference_schema.ref_countries.country_active
    is 'Признак активности страны';

alter table reference_schema.ref_countries
    owner to nrmmo;

create table reference_schema.ref_languages
(
    language_id            bigint generated always as identity,
    language_version       integer default 0    not null,
    language_name          varchar(255)         not null,
    language_official_name varchar(255)         not null,
    language_iso           varchar(2)           not null,
    language_code          varchar(3)           not null,
    language_active        boolean default true not null,
    constraint pk_ref_languages_lid
        primary key (language_id),
    constraint chk_ref_languages_lv
        check (language_version >= 0)
);

comment on table reference_schema.ref_languages
    is 'Таблица для хранения справочника языков согласно стандарту ISO 639-1';

comment on column reference_schema.ref_languages.language_id
    is 'Идентификатор языка';

comment on column reference_schema.ref_languages.language_name
    is 'Наименование языка';

comment on column reference_schema.ref_languages.language_official_name
    is 'Официальное наименование языка';

comment on column reference_schema.ref_languages.language_iso
    is 'Код языка согласно стандарту ISO 639-1';

comment on column reference_schema.ref_languages.language_code
    is 'Цифровой код языка согласно стандарту ISO 639-1';

comment on column reference_schema.ref_languages.language_active
    is 'Признак активности языка';

alter table reference_schema.ref_languages
    owner to nrmmo;

create table reference_schema.ref_messages
(
    message_id      bigint generated always as identity,
    message_version integer default 0    not null,
    language_id     bigint               not null,
    message_code    varchar(255)         not null,
    message_format  varchar(1000)        not null,
    message_note    varchar(1000),
    message_active  boolean default true not null,
    constraint pk_ref_messages_mid
        primary key (message_id),
    constraint fk_ref_messages_lid
        foreign key (language_id)
            references reference_schema.ref_languages (language_id)
            on update cascade
            on delete no action,
    constraint uk_ref_messages_lc_mk
        unique (language_id, message_code),
    constraint chk_ref_messages_mv
        check (message_version >= 0)
);

comment on table reference_schema.ref_messages
    is 'Таблица для хранения справочника локализованных сообщений';

comment on column reference_schema.ref_messages.message_id
    is 'Идентификатор локализованного сообщения';

comment on column reference_schema.ref_messages.language_id
    is 'Идентификатор языка локализации сообщения';

comment on column reference_schema.ref_messages.message_code
    is 'Символьный код локализованного сообщения';

comment on column reference_schema.ref_messages.message_format
    is 'Шаблон локализованного сообщения';

comment on column reference_schema.ref_messages.message_note
    is 'Описание локализованного сообщения';

alter table reference_schema.ref_messages
    owner to nrmmo;
