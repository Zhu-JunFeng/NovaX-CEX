# 数据库说明

当前项目统一使用：

- PostgreSQL
- MyBatis-Plus
- Druid
- DDD 分层持久化模型

在 DDD 结构下：

- `domain`：放领域模型、领域仓储接口
- `application`：放用例编排
- `infrastructure.persistence.dataobject`：放 DO
- `infrastructure.persistence.mapper`：放 MyBatis Mapper
- `infrastructure.persistence.repository`：放仓储实现

## 命名规则

所有表统一使用小写蛇形命名，并且必须带微服务名前缀：

```text
<service_prefix>_<table_name>
```

例如：

- `gateway_routes`
- `user_profiles`
- `account_assets`
- `account_balance_journals`
- `order_orders`
- `order_trades`
- `matching_symbols`
- `market_klines`
- `wallet_withdraw_requests`
- `futures_positions`

即使当前每个微服务已经拆分独立数据库，表名前缀仍然必须保留，方便后续做：

- 对账数据导出
- 数仓汇总
- 多库合并
- 审计追踪

## 数据库拆分

当前每个微服务对应一个独立数据库：

- `gateway-service` -> `novax_gateway`
- `user-service` -> `novax_user`
- `account-service` -> `novax_account`
- `order-service` -> `novax_order`
- `matching-engine-service` -> `novax_matching`
- `clearing-service` -> `novax_clearing`
- `market-service` -> `novax_market`
- `websocket-service` -> `novax_websocket`
- `wallet-service` -> `novax_wallet`
- `risk-service` -> `novax_risk`
- `margin-service` -> `novax_margin`
- `futures-service` -> `novax_futures`
- `admin-service` -> `novax_admin`

## SQL 目录

初始化脚本已经补齐到 `sql/postgresql`：

- `sql/postgresql/00-create-databases.sql`：创建所有微服务数据库
- `sql/postgresql/<service>/01-schema.sql`：初始化每个微服务的核心表

每个服务当前至少提供：

- 1 张核心业务主表
- 1 张辅助表 / 日志表 / 明细表

## 当前核心表示例

- `gateway_routes`：网关路由配置
- `gateway_access_policies`：网关访问策略
- `user_profiles`：用户主档
- `user_kyc_records`：KYC 审核记录
- `account_assets`：账户资产快照
- `account_balance_journals`：余额流水
- `order_orders`：订单主表
- `order_trades`：成交明细
- `matching_symbols`：撮合交易对
- `matching_order_books`：盘口快照
- `clearing_records`：清算结果
- `clearing_fee_records`：手续费记录
- `market_tickers`：Ticker 快照
- `market_klines`：K 线数据
- `websocket_sessions`：WebSocket 会话
- `websocket_subscriptions`：订阅关系
- `wallet_transactions`：钱包流水
- `wallet_withdraw_requests`：提现申请
- `risk_rules`：风控规则
- `risk_alert_records`：风控告警
- `margin_positions`：杠杆仓位
- `margin_borrow_records`：借贷记录
- `futures_positions`：合约仓位
- `futures_funding_records`：资金费率记录
- `admin_operators`：后台操作员
- `admin_operation_logs`：后台操作日志

## 建模约束

- 余额类表必须区分 `available_balance` 与 `frozen_balance`
- 任何资产变动都必须可追溯到流水表
- 核心交易数据禁止只保留聚合结果，必须保留明细
- 订单、成交、清算、资金流水之间要保留可串联的业务单号
- 所有业务表都统一保留：
  - `id`
  - `version`
  - `created_at`
  - `updated_at`

## 后续建议

后续进入真实业务开发时，建议继续补齐：

- 唯一索引
- 常用查询索引
- 外键策略或逻辑约束策略
- 分区表策略
- 历史归档表策略
