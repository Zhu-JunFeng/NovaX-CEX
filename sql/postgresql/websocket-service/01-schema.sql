-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists websocket_sessions (
    id varchar(64) primary key default gen_random_uuid()::text,
    session_id varchar(128) not null,
    channel_code varchar(64) not null,
    principal_id varchar(64) not null,
    status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists websocket_subscriptions (
    id varchar(64) primary key default gen_random_uuid()::text,
    session_id varchar(128) not null,
    topic_code varchar(128) not null,
    principal_id varchar(64) not null,
    qos_level integer not null default 0,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
