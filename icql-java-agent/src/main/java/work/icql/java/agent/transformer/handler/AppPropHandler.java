package work.icql.java.agent.transformer.handler;

public class AppPropHandler extends AbstractHandler {

    private static final String MYSQL_IP = "127.0.0.1";

    private static final String MYSQL_PORT = "3306";

    private static final String MYSQL_USERNAME = "root";

    private static final String MYSQL_PASSWORD = "root";

    private static final String REDIS_IP = "127.0.0.1";

    private static final String REDIS_PORT = "6379";

    public AppPropHandler(String agentArgs) {
        super(agentArgs);
        handleClassName = "org.springframework.boot.env.OriginTrackedPropertiesLoader";
    }

    @Override
    public byte[] actualHandle(byte[] classfileBuffer) {
        String mysqlIp = handleConfMap.getOrDefault("mysqlIp", MYSQL_IP).toString();
        String mysqlPort = handleConfMap.getOrDefault("mysqlPort", MYSQL_PORT).toString();
        String mysqlUsername = handleConfMap.getOrDefault("mysqlUsername", MYSQL_USERNAME).toString();
        String mysqlPassword = handleConfMap.getOrDefault("mysqlPassword", MYSQL_PASSWORD).toString();
        String redisIp = handleConfMap.getOrDefault("redisIp", REDIS_IP).toString();
        String redisPort = handleConfMap.getOrDefault("redisPort", REDIS_PORT).toString();
        return consumerMethod(classfileBuffer, handleClassName, "loadValue", ctMethod ->
                ctMethod.setBody("{" +
                        "        String key = $1.toString();\n" +
                        "        \n" +
                        "        $1.setLength(0);\n" +
                        "        while ($2.isWhiteSpace() && !$2.isEndOfLine()) {\n" +
                        "            $2.read();\n" +
                        "        }\n" +
                        "        org.springframework.boot.origin.TextResourceOrigin.Location location = $2.getLocation();\n" +
                        "        while (!$2.isEndOfLine() && !($3 && $2.isListDelimiter())) {\n" +
                        "            $1.append($2.getCharacter());\n" +
                        "            $2.read();\n" +
                        "        }\n" +
                        "        org.springframework.boot.origin.Origin origin = new org.springframework.boot.origin.TextResourceOrigin($0.resource, location);\n" +
                        "        \n" +
                        "        String value = $1.toString();\n" +
                        "        if (key.endsWith(\"jdbc-url\")) {\n" +
                        "            String[] split = value.split(\"/\");\n" +
                        "            split[2] = \"" + mysqlIp + ":" + mysqlPort + "\";\n" +
                        "            value = String.join(\"/\", split);\n" +
                        "        } else if (key.endsWith(\"username\")) {\n" +
                        "            value = \"" + mysqlUsername + "\";\n" +
                        "        } else if (key.endsWith(\"password\")) {\n" +
                        "            value = \"" + mysqlPassword + "\";\n" +
                        "        } else if (key.endsWith(\"spring.redis.host\")) {\n" +
                        "            value = \"" + redisIp + "\";\n" +
                        "        } else if (key.endsWith(\"spring.redis.port\")) {\n" +
                        "            value = \"" + redisPort + "\";\n" +
                        "        }\n" +
                        "        \n" +
                        "        return org.springframework.boot.origin.OriginTrackedValue.of(value, origin);" +
                        "}"), "处理应用配置(db/redis等)");
    }
}

