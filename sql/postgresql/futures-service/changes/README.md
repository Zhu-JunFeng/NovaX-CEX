# futures-service DDL 变更记录

- 基线建表脚本：`sql/postgresql/futures-service/01-schema.sql`
- 增量 DDL 请放在当前目录下，禁止直接覆盖历史变更文件。
- 推荐文件名：`YYYY-MM-DD-序号-变更主题.sql`
- 每个 SQL 文件都应写清楚目标数据库、影响表、执行顺序、回滚说明。
- 发版或联调前，请确认对应业务说明已同步到 `docs/changes/futures-service/`。
