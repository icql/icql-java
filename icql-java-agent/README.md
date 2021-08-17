# icql-java-agent

## 简介


目前支持的功能有：
```text
1) 处理应用配置(db/redis等)
替换 springboot 配置文件中的 mysql,redis 等的 ip、账号密码，目前仅处理 .properties 配置文件

```

## 使用方法

### 1) icql-java-agent.jar
mvn package

### 2) 服务配置

``` shell
服务vm参数:
-javaagent:[agent.jar绝对路径]=[配置参数文件绝对路径]

示例:
-javaagent:/icql-java-agent-0.1.0-SNAPSHOT-jar-with-dependencies.jar=/agentArgs.json
```

### 3) 配置参数

#### (1) 参数说明

配置参数文件绝对路径：为空时，默认开启所有代理，on 字段用于是否开启该处理器

#### (2) 参数文件
agentArgs.json
``` json
{
  "AppPropHandler": {
    "on": true,
    "mysqlIp": "127.0.0.1",
    "mysqlPort": "3306",
    "mysqlUsername": "root",
    "mysqlPassword": "root",
    "redisIp": "127.0.0.1",
    "redisPort": "6379"
  }
}
```
