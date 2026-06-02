-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists market_tickers (
    id varchar(64) primary key default gen_random_uuid()::text,
    symbol_code varchar(64) not null,
    last_price numeric(36, 18) not null default 0,
    mark_price numeric(36, 18) not null default 0,
    status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists market_klines (
    id varchar(64) primary key default gen_random_uuid()::text,
    symbol_code varchar(64) not null,
    interval_code varchar(16) not null,
    open_price numeric(36, 18) not null,
    close_price numeric(36, 18) not null,
    ts_open timestamptz not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
