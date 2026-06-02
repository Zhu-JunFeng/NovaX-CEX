-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists order_orders (
    id varchar(64) primary key default gen_random_uuid()::text,
    order_no varchar(64) not null,
    account_id varchar(64) not null,
    symbol_code varchar(64) not null,
    side varchar(16) not null,
    type varchar(16) not null,
    quantity numeric(36, 18) not null,
    price numeric(36, 18),
    status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists order_trades (
    id varchar(64) primary key default gen_random_uuid()::text,
    trade_no varchar(64) not null,
    order_id varchar(64) not null,
    symbol_code varchar(64) not null,
    trade_price numeric(36, 18) not null,
    trade_quantity numeric(36, 18) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
