-- 初始化核心表结构。
create extension if not exists "pgcrypto";

create table if not exists admin_operators (
    id varchar(64) primary key default gen_random_uuid()::text,
    operator_no varchar(64) not null,
    display_name varchar(128) not null,
    role_code varchar(64) not null,
    status varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table if not exists admin_operation_logs (
    id varchar(64) primary key default gen_random_uuid()::text,
    operator_no varchar(64) not null,
    action_code varchar(64) not null,
    target_type varchar(64) not null,
    target_id varchar(64) not null,
    result_code varchar(32) not null,
    version bigint not null default 0,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);
