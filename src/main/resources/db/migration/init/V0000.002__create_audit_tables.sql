create table audit_schema.chat_global_logs
(
    chat_global_log_id      bigint generated always as identity,
    chat_global_log_version integer default 0 not null
);

create table audit_schema.chat_private_logs
(
    chat_private_log_id      bigint generated always as identity,
    chat_private_log_version integer default 0 not null
);

create table audit_schema.logs
(
    log_id      bigint generated always as identity,
    log_version integer default 0 not null
);

create table audit_schema.trade_market_logs
(
    trade_market_log_id      bigint generated always as identity,
    trade_market_log_version integer default 0 not null
);

create table audit_schema.trade_p2p_logs
(
    trade_p2p_log_id      bigint generated always as identity,
    trade_p2p_log_version integer default 0 not null
);
