-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists futures_positions (
    id varchar(64) primary key default gen_random_uuid()::text,
    account_id varchar(64) not null,
    symbol_code varchar(64) not null,
    position_side varchar(32) not null,
    position_qty numeric(36, 18) not null default 0,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists futures_funding_records (
    id varchar(64) primary key default gen_random_uuid()::text,
    symbol_code varchar(64) not null,
    funding_time timestamptz not null,
    funding_rate numeric(18, 8) not null,
    mark_price numeric(36, 18) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
