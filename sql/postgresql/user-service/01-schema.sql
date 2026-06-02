-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists user_profiles (
    id varchar(64) primary key default gen_random_uuid()::text,
    user_no varchar(64) not null,
    display_name varchar(128) not null,
    kyc_level varchar(32) not null,
    status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists user_kyc_records (
    id varchar(64) primary key default gen_random_uuid()::text,
    user_id varchar(64) not null,
    level_code varchar(32) not null,
    review_status varchar(32) not null,
    reviewer varchar(64),
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
