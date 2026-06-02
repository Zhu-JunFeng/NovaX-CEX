# 模块地图

## Platform

- `common`：公共响应模型、分页、ID、时间工具、共享异常
- `security`：签名鉴权、主体信息、权限边界契约
- `event-schema`：跨服务事件模型、Topic 约定、事件信封
- `persistence`：MyBatis-Plus、Druid、基础 DO、Mapper 扫描等共享持久化支持
- `test-kit`：复用测试工具与基础 smoke test

## Services

- `gateway-service`：统一 API 入口、鉴权、路由、限流扩展位
- `user-service`：用户、KYC、权限、子账户等用户中心能力
- `account-service`：账户余额、冻结金额、账务流水
- `order-service`：订单受理、状态流转、撤单与成交前置链路
- `matching-engine-service`：订单簿、撮合逻辑、撮合快照
- `clearing-service`：成交清算、手续费入账、资金资产分录
- `market-service`：行情快照、Ticker、Depth、KLine
- `websocket-service`：订阅关系管理、推送连接、公共/私有流推送
- `wallet-service`：充值、提现、钱包流水、链上回执扩展位
- `risk-service`：规则校验、风险告警、强平信号扩展位
- `margin-service`：杠杆借贷、利息、杠杆仓位
- `futures-service`：合约仓位、标记价格、资金费率
- `admin-service`：后台操作员、参数配置、运营操作审计
