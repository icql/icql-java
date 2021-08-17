package work.icql.java.agent.transformer;


import work.icql.java.agent.transformer.handler.AbstractHandler;
import work.icql.java.agent.transformer.handler.AppPropHandler;
import work.icql.java.agent.transformer.handler.DefaultHandler;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

public class HandlerTransformer implements ClassFileTransformer {

    private final Map<String, AbstractHandler> handlerByClassNameMap = new HashMap<>();

    private final AbstractHandler defaultHandler;

    public HandlerTransformer(String agentArgs) {
        //默认处理器
        defaultHandler = new DefaultHandler(agentArgs);
        //其他处理器
        AppPropHandler appPropHandler = new AppPropHandler(agentArgs);

        //处理应用配置(db/redis等)
        handlerByClassNameMap.put(appPropHandler.getHandleClassName(), appPropHandler);
    }

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer)
            throws IllegalClassFormatException {
        className = className.replace('/', '.');
        return handlerByClassNameMap.getOrDefault(className, defaultHandler)
                .handle(classfileBuffer);
    }
}