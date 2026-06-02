-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists clearing_records (
    id varchar(64) primary key default gen_random_uuid()::text,
    biz_id varchar(64) not null,
    account_id varchar(64) not null,
    asset_code varchar(32) not null,
    amount numeric(36, 18) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists clearing_fee_records (
    id varchar(64) primary key default gen_random_uuid()::text,
    biz_id varchar(64) not null,
    fee_asset varchar(32) not null,
    fee_amount numeric(36, 18) not null,
    fee_type varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
