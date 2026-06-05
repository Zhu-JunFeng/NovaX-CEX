# NovaX CEX

NovaX CEX 是一个基于 Java 21、Spring Boot 3、Maven 多模块、MyBatis-Plus、Druid 的中心化交易所（CEX）学习型项目骨架。

项目按照 `交易所核心业务与核心技术学习路线.md` 中的模块拆分来设计，当前以“现货交易主链路优先”的方式搭建基础框架，同时为杠杆、合约、钱包、风控、后台等模块预留清晰边界。

## 项目目标

- 先把交易所核心模块边界搭清楚，再逐步补业务实现
- 优先保证结构清晰、职责明确、后续容易扩展
- 核心业务代码按 DDD 分层组织：`api`、`application`、`domain`、`infrastructure`
- 先支持现货交易主链路：下单、撮合、清结算、行情
- 为杠杆、合约、钱包、风控、后台管理预留独立服务与事件契约

## 目录结构

- `platform/`：公共平台模块，放通用能力、共享契约、基础设施支持
- `services/`：业务服务模块，按交易所业务域拆分
- `docs/`：架构、事件、模块、数据库等设计文档
- `docker-compose.yml`：本地 PostgreSQL、Redis、Kafka 依赖编排
- `pom.xml`：根 Maven 聚合工程
- `AGENTS.md`：AI 开发规范


## 数据库规划

当前默认连接远程 PostgreSQL `182.92.160.46:5432`，并按“每个服务一个独立数据库”的方式使用以下数据库：

- `novax_gateway`
- `novax_user`
- `novax_account`
- `novax_order`
- `novax_matching`
- `novax_clearing`
- `novax_market`
- `novax_websocket`
- `novax_wallet`
- `novax_risk`
- `novax_margin`
- `novax_futures`
- `novax_admin`

如果后续仍需本地初始化同名数据库，可参考脚本：`docker/postgres/init/01-create-databases.sql`

### 表命名规则

虽然当前按“每个微服务一个数据库”来拆分，但表名仍统一要求加上微服务名前缀。

这样做的原因是：

- 避免不同服务未来做数据汇总时出现同名表冲突
- 避免后续合库、归档、对账、数仓同步时语义不清
- 让运维、DBA、数据分析在只看表名时就能知道归属服务

命名格式：

```text
<service_prefix>_<table_name>
```

例如：

- `account_balance`
- `account_balance_journal`
- `order_order`
- `order_trade`
- `market_kline`
- `wallet_withdraw_request`
- `futures_position`

不推荐：

- `balances`
- `orders`
- `trades`
- `kline`

推荐做法是：即使数据库已经按服务拆开，表名也不要偷懒省掉前缀。

## 技术栈

- Java 21
- Spring Boot 3.3.2
- MyBatis-Plus 3.5.x
- Druid 1.2.x
- Maven 多模块工程
- PostgreSQL
- Redis
- Kafka

## 服务端口规划

- `gateway-service`: `18080`
- `user-service`: `18081`
- `account-service`: `18082`
- `order-service`: `18083`
- `matching-engine-service`: `18084`
- `clearing-service`: `18085`
- `market-service`: `18086`
- `websocket-service`: `18087`
- `wallet-service`: `18088`
- `risk-service`: `18089`
- `margin-service`: `18090`
- `futures-service`: `18091`
- `admin-service`: `18092`

## 快速开始

当前各服务默认直接连接远程 PostgreSQL：`182.92.160.46:5432`。

```bash
mvn test
mvn -pl services/gateway-service spring-boot:run
```

## 当前模块说明

### 1. platform 公共平台模块

#### `platform/common`

通用基础模块，给所有服务复用。

当前主要职责：

- 统一 API 返回结构
- 通用分页对象
- 通用异常定义
- 时间工具
- ID 生成工具
- 审计元数据对象

适合继续往里放：

- 通用枚举
- 错误码体系
- 公共工具类
- 基础领域对象

#### `platform/security`

安全与鉴权公共模块。

当前主要职责：

- API Key 主体模型
- 权限集合模型
- 请求签名校验接口

后续可扩展：

- API Key 鉴权
- HMAC 签名校验
- 子账户权限控制
- 访问控制与角色模型

#### `platform/event-schema`

事件契约模块，负责统一服务之间的事件格式。

当前主要职责：

- 通用事件信封 `EventEnvelope`
- Topic 常量定义
- 订单、成交、深度、充值等事件模型

这个模块很关键，因为后续服务之间通过 Kafka 通信时，消息格式要统一，不能每个服务自己定义一套。

#### `platform/persistence`

持久化基础模块。

当前主要职责：

- JPA 基础配置
- 基础实体父类
- 乐观锁和审计字段承载基础

后续可扩展：

- Repository 基础支持
- 分页与查询封装
- 审计字段自动填充
- 多数据源支持

#### `platform/test-kit`

测试基础模块。

当前主要职责：

- 放测试基类
- 放测试工具
- 放后续 Testcontainers 相关支持

后续所有服务的公共测试能力都可以沉淀在这里，避免重复造轮子。

### 2. services 业务服务模块

#### `services/gateway-service`

网关服务。

作用：

- 作为外部请求统一入口
- 后续承接鉴权、路由、限流、签名校验
- 对外暴露统一 API 访问层

当前是占位骨架，后续可以演进为 API Gateway 或 BFF 层。

#### `services/user-service`

用户服务。

作用：

- 用户注册与资料管理
- KYC 信息管理
- 子账户管理
- API Key 管理
- 用户权限与风控标签管理

这是交易所“人”的入口模块，后续很多权限和风控逻辑都要从这里拿用户信息。

#### `services/account-service`

账户与资产服务。

作用：

- 账户体系管理
- 用户资产余额管理
- 可用余额 / 冻结余额维护
- 账务流水记录
- 冻结、解冻、划转等资产动作

这是交易所最核心的底层模块之一。交易所可以慢，但账不能错。

#### `services/order-service`

订单服务，负责现货订单受理。

作用：

- 接收下单请求
- 接收撤单请求
- 维护订单生命周期
- 校验订单基础字段
- 把订单送到撮合引擎或事件总线

当前已经有最基础的下单、撤单、状态接口骨架。

#### `services/matching-engine-service`

撮合引擎服务。

作用：

- 维护订单簿
- 按价格优先、时间优先撮合
- 输出成交结果
- 生成订单簿快照或深度变化

这个模块后续是现货和部分合约能力的核心技术模块，但它本身不负责账务落库。

#### `services/clearing-service`

清结算服务。

作用：

- 消费撮合结果
- 处理买卖双方资产变更
- 处理手续费结算
- 写账务流水
- 保证成交之后账务状态正确

可以理解为：撮合负责“成交”，清结算负责“成交之后钱怎么变”。

#### `services/market-service`

行情服务。

作用：

- 生成最新成交
- 生成盘口深度
- 生成 ticker
- 生成 K 线
- 为 WebSocket 和行情查询提供数据支持

它主要消费成交和订单簿变化事件，把内部状态加工成用户能看到的市场数据。

#### `services/websocket-service`

WebSocket 推送服务。

作用：

- 推送用户订单回报
- 推送用户成交回报
- 推送公开行情流
- 推送深度、ticker、K 线等实时数据

后续它会成为“用户实时感知交易所状态”的出口。

#### `services/wallet-service`

钱包服务。

作用：

- 充值记录管理
- 提现申请管理
- 提现审核流转
- 链上确认状态跟踪
- 对接链上钱包或 mock 钱包

当前先是骨架，后续可以先从模拟充值提现做起，再逐步接入真实链。

#### `services/risk-service`

风控服务。

作用：

- 下单前风控检查
- 账户风险检查
- 提现风控检查
- 合约强平信号计算
- 风险告警输出

这个模块后续会越来越重要，尤其在合约和提现场景里。

#### `services/margin-service`

杠杆服务。

作用：

- 借币与还币
- 利息计算
- 全仓 / 逐仓逻辑预留
- 杠杆账户和风险率模型预留

当前以领域边界和服务骨架为主，后续可以从简化逐仓杠杆开始做。

#### `services/futures-service`

合约服务。

作用：

- U 本位永续合约仓位管理
- 保证金管理
- 未实现盈亏计算
- 标记价格与强平价格模型承载
- 资金费率、强平流程预留

这个模块会是后续复杂度最高的模块之一，当前先把模型和边界搭出来。

#### `services/admin-service`

后台管理服务。

作用：

- 币种配置
- 交易对配置
- 费率配置
- 风控参数配置
- 审计与运营管理入口

它主要服务内部运营、风控、财务、后台管理人员。

## 当前现货主链路定位

目前整个工程最优先围绕这条链路演进：

```text
用户请求
  -> gateway-service
  -> order-service
  -> matching-engine-service
  -> clearing-service
  -> market-service
  -> websocket-service
```

对应含义：

- `gateway-service`：接请求
- `order-service`：收订单
- `matching-engine-service`：撮合成交
- `clearing-service`：更新资产和流水
- `market-service`：更新行情
- `websocket-service`：把结果推给用户和市场订阅者

## 文档说明

- `docs/architecture.md`：整体架构说明
- `docs/modules.md`：模块清单和职责
- `docs/events.md`：事件主题与事件模型说明
- `docs/database.md`：数据库设计起点
- `docs/changes/`：按微服务拆分的模块变更记录

## 模块变更与 DDL 记录规范

为了避免“代码改了，但没人知道改了什么、表怎么变的”的问题，当前仓库统一要求每个模块都保留两类记录：

- 模块变更文档：`docs/changes/<service>/`
- 数据库 DDL 记录：`sql/postgresql/<service>/changes/`

执行规则：

- 每次改动某个微服务，都要在 `docs/changes/<service>/` 新增一条 Markdown 记录。
- 如果改动涉及表结构、索引、约束、字段类型、默认值等数据库变更，必须同步在 `sql/postgresql/<service>/changes/` 新增对应 SQL。
- 如果本次没有 DDL，也要在变更文档里明确写出“本次无 DDL 变更”。
- 一次需求如果同时改多个模块，要分别记录到各自模块目录，不要混写。

推荐命名格式：

```text
docs/changes/<service>/YYYY-MM-DD-序号-变更主题.md
sql/postgresql/<service>/changes/YYYY-MM-DD-序号-变更主题.sql
```

例如：

- `docs/changes/order-service/2026-06-03-001-add-order-fee.md`
- `sql/postgresql/order-service/changes/2026-06-03-001-add-order-fee.sql`

## 当前阶段说明

当前项目是“先把架子搭好”的阶段，重点是：

- 模块拆分正确
- 包结构清晰
- 服务边界明确
- 事件契约统一
- 方便后续逐步填充业务实现

现在还不是完整可用交易所，只是一个适合继续迭代实现的小型 CEX 框架起点。
