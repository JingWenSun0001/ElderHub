# ElderHub 养老服务管理平台（东软颐养中心）

面向养老院/社区养老中心的前后端分离管理系统，覆盖客户档案、入住登记、床位管理、护理级别/项目/记录、外出与退住审批、餐饮管理、系统用户权限等业务。

## 技术栈

- 后端：Spring Boot 3.1.10 + MyBatis-Plus 3.5.6 + MySQL 8.0 + JWT（jjwt 0.12.5），JDK 17，Maven Wrapper（`mvnw.cmd`）
- 前端：Vue 3 + Vite + Element Plus + Pinia + Vue Router + Axios
- 数据库：MySQL 8.0，库名 `elderhub`

## 环境准备

- JDK 17
- MySQL 8.0（本机 root 密码默认为 `123456`，可在配置中修改）
- Node.js 16+（建议 18+）
- Maven 无需单独安装（使用项目自带 `mvnw.cmd`）

## 运行步骤

### 1. 初始化数据库

启动 MySQL 后，创建数据库并按顺序执行 `sql/` 目录下全部脚本（00 建库，01~18 建表及基础数据）：

```powershell
# 进入 sql 目录，按文件名顺序执行
& "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -uroot -p123456 < sql\00_create_database.sql
# 依次执行 01 ~ 18 的脚本（可用循环一次性执行）
Get-ChildItem sql\*.sql | Sort-Object Name | ForEach-Object {
  & "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -uroot -p123456 elderhub -e ("source " + $_.FullName)
}
```

### 2. 初始化测试数据（测试账号）

在前端项目目录执行 seed 脚本，创建测试账号并补齐列：

```powershell
cd elderhub-frontend\elderhub-frontend
npm install        # 首次运行先装依赖
npm run seed
```

测试账号：

| 账号     | 密码 | 角色 |
|-------|---|---|
| admin     | 123456 | 系统管理员 |
| admin0001 | 123456 | 健康管家 |

### 3. 启动后端

```powershell
# 项目根目录（pom.xml 所在目录）
.\mvnw.cmd spring-boot:run
```

- 服务端口：`8080`，上下文路径：`/ElderHub`
- 接口示例：`http://localhost:8080/ElderHub/auth/login`
- 数据库连接配置在 `src/main/resources/application.yml`（默认 `root/123456`、库 `elderhub`）

### 4. 启动前端

```powershell
cd elderhub-frontend\elderhub-frontend
npm run dev
```

- 访问地址：`http://localhost:5173`
- Vite 已配置代理：`/api` → `http://localhost:8080/ElderHub`，无需改前端接口地址

## 启动顺序速查

```
MySQL 启动 → 执行 sql/*.sql → npm run seed → mvnw spring-boot:run → npm run dev
```

浏览器打开 `http://localhost:5173`，用 `admin/123456` 登录即可。

## 常见问题

- **前端请求 403/跨域**：后端 `CorsConfig` 已放行 5173 端口，确认前端跑在 5173 即可。
- **登录提示账号不存在**：先执行 `npm run seed` 创建测试账号。
- **端口被占用**：后端 8080、前端 5173；释放占用进程或修改对应配置。
- **表/字段不存在**：确认 `sql/` 脚本全部执行，且后端 `application.yml` 中 `table-prefix: t_` 与实体 `@TableName` 保持一致。
