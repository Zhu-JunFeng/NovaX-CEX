-- 为各服务预创建独立数据库，方便后续按服务拆分持久化边界。
CREATE DATABASE novax_gateway;
CREATE DATABASE novax_user;
CREATE DATABASE novax_account;
CREATE DATABASE novax_order;
CREATE DATABASE novax_matching;
CREATE DATABASE novax_clearing;
CREATE DATABASE novax_market;
CREATE DATABASE novax_websocket;
CREATE DATABASE novax_wallet;
CREATE DATABASE novax_risk;
CREATE DATABASE novax_margin;
CREATE DATABASE novax_futures;
CREATE DATABASE novax_admin;
