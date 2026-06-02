-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists margin_positions (
    id varchar(64) primary key default gen_random_uuid()::text,
    account_id varchar(64) not null,
    symbol_code varchar(64) not null,
    borrowed_amount numeric(36, 18) not null default 0,
    health_status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists margin_borrow_records (
    id varchar(64) primary key default gen_random_uuid()::text,
    borrow_no varchar(64) not null,
    account_id varchar(64) not null,
    asset_code varchar(32) not null,
    borrowed_amount numeric(36, 18) not null,
    interest_rate numeric(18, 8) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
