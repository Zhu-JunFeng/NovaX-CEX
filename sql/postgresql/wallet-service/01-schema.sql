-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists wallet_transactions (
    id varchar(64) primary key default gen_random_uuid()::text,
    wallet_tx_no varchar(64) not null,
    asset_code varchar(32) not null,
    direction varchar(32) not null,
    amount numeric(36, 18) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists wallet_withdraw_requests (
    id varchar(64) primary key default gen_random_uuid()::text,
    request_no varchar(64) not null,
    asset_code varchar(32) not null,
    address varchar(256) not null,
    amount numeric(36, 18) not null,
    status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
