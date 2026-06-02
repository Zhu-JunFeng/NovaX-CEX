-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists account_assets (
    id varchar(64) primary key default gen_random_uuid()::text,
    account_id varchar(64) not null,
    asset_code varchar(32) not null,
    available_balance numeric(36, 18) not null default 0,
    frozen_balance numeric(36, 18) not null default 0,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists account_balance_journals (
    id varchar(64) primary key default gen_random_uuid()::text,
    account_id varchar(64) not null,
    asset_code varchar(32) not null,
    journal_type varchar(32) not null,
    delta_amount numeric(36, 18) not null,
    reference_no varchar(64) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
