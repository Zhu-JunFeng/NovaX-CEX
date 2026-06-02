-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists risk_rules (
    id varchar(64) primary key default gen_random_uuid()::text,
    rule_code varchar(64) not null,
    scene_code varchar(64) not null,
    severity varchar(32) not null,
    enabled boolean not null default true,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists risk_alert_records (
    id varchar(64) primary key default gen_random_uuid()::text,
    alert_no varchar(64) not null,
    scene_code varchar(64) not null,
    severity varchar(32) not null,
    status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
