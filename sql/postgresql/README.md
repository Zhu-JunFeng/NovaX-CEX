# PostgreSQL 初始化脚本

- `00-create-databases.sql`：创建 NovaX CEX 所有微服务数据库。
- `<service>/01-schema.sql`：初始化单个微服务的核心表结构。
- 所有表名都遵循 `<微服务前缀>_<表名>` 规则。
- 脚本默认面向 PostgreSQL 15+，字符集与时区跟随实例配置。
