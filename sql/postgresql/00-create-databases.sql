-- 按微服务拆分数据库，便于隔离部署与权限控制。
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
