-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists gateway_routes (
    id varchar(64) primary key default gen_random_uuid()::text,
    route_key varchar(64) not null,
    target_service varchar(64) not null,
    uri_pattern varchar(256) not null,
    enabled boolean not null default true,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists gateway_access_policies (
    id varchar(64) primary key default gen_random_uuid()::text,
    policy_code varchar(64) not null,
    route_key varchar(64) not null,
    policy_type varchar(32) not null,
    enabled boolean not null default true,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
