# 架构总览

NovaX CEX 采用单仓多服务结构，基于 Spring Boot + MyBatis-Plus + Druid，并按 DDD 思路拆分应用层、领域层和基础设施层。

现阶段核心现货链路如下：

1. `gateway-service`：接收请求、做统一鉴权和路由转发
2. `order-service`：负责订单受理、校验、落库和状态推进
3. `matching-engine-service`：负责订单簿与撮合计算
4. `clearing-service`：负责成交后的清算、手续费与账务分录
5. `market-service`：负责生成 ticker、深度、K 线等行情结果
6. `websocket-service`：负责推送公共流和私有流

为了后续扩展，杠杆、合约、钱包、风控、管理后台均独立成服务边界。

## DDD 骨架约定

每个微服务统一优先具备以下目录：

- `api`：Controller、请求 DTO、响应 DTO
- `application`：用例编排、事务边界
- `domain.model`：领域实体 / 值对象 / 聚合
- `domain.repository`：领域仓储接口
- `domain.port`：领域对外能力接口
- `infrastructure.config`：基础设施装配
- `infrastructure.persistence.dataobject`：数据库 DO
- `infrastructure.persistence.mapper`：MyBatis Mapper
- `infrastructure.persistence.repository`：仓储实现

其中：

- 领域模型不直接带数据库注解
- 持久化注解只放在 DO 上
- 仓储实现负责完成 Domain <-> DO 的转换
