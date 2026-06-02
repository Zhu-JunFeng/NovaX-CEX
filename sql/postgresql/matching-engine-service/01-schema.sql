-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists matching_symbols (
    id varchar(64) primary key default gen_random_uuid()::text,
    symbol_code varchar(64) not null,
    base_asset varchar(32) not null,
    quote_asset varchar(32) not null,
    status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists matching_order_books (
    id varchar(64) primary key default gen_random_uuid()::text,
    symbol_code varchar(64) not null,
    snapshot_version bigint not null default 0,
    bid_depth jsonb not null default '[]'::jsonb,
    ask_depth jsonb not null default '[]'::jsonb,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
