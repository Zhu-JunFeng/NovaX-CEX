# PostgreSQL 初始化脚本

- `00-create-databases.sql`：创建 NovaX CEX 所有微服务数据库。
- `<service>/01-schema.sql`：初始化单个微服务的核心表结构。
- 所有表名都遵循 `<微服务前缀>_<表名>` 规则。
- 脚本默认面向 PostgreSQL 15+，字符集与时区跟随实例配置。


## 增量 DDL 记录规范

- 基线建表脚本保留在各服务目录下的 `01-schema.sql`。
- 后续每次表结构变更，必须额外新增到 `sql/postgresql/<service>/changes/` 目录。
- 建议命名格式：`YYYY-MM-DD-序号-变更主题.sql`。
- SQL 文件开头应写清楚目标数据库、影响表、执行前置条件和是否可回滚。
- 与 SQL 对应的业务说明，必须同步记录到 `docs/changes/<service>/`。
