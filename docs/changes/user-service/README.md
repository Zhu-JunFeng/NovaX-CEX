# user-service 变更记录

## 使用说明

- 本目录记录 `user-service` 的功能、接口、配置、事件、数据库相关改动。
- 每次改动 `user-service` 时，新增一份 Markdown 记录，不要覆盖历史文件。
- 推荐文件名：`YYYY-MM-DD-序号-变更主题.md`。
- 如果涉及 DDL，必须同步更新 `sql/postgresql/user-service/changes/`。
- 如果不涉及 DDL，也要在记录中明确写“本次无 DDL 变更”。

## 推荐模板

```md
# 变更主题

- 日期：YYYY-MM-DD
- 负责人：
- 影响模块：user-service
- 关联需求：

## 改动内容
- 

## 影响范围
- 接口：
- 事件：
- 配置：
- 数据模型：

## DDL 变更
- SQL 文件：
- 影响数据库：
- 影响表：
- 回滚说明：

## 验证记录
- 
```
