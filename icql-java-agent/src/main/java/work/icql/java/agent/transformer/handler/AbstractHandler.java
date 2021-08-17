package work.icql.java.agent.transformer.handler;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import work.icql.java.agent.util.FileUtils;
import work.icql.java.agent.util.JsonUtils;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractHandler {

    protected String agentArgs;

    protected String handleClassName;

    protected Map<String, Object> handleConfMap;

    private static final String LOG_PATTEN = "---------- 本地代理-{0},{1} ----------";

    public AbstractHandler(String agentArgs) {
        //agent参数
        this.agentArgs = agentArgs;
        //处理器配置
        handleConfMap = (Map) JsonUtils.json2Map(FileUtils.readFile(agentArgs)).get(this.getClass().getSimpleName());
        if (handleConfMap == null) {
            handleConfMap = Collections.emptyMap();
        }
    }

    public String getHandleClassName() {
        return handleClassName;
    }

    public byte[] handle(byte[] classfileBuffer) {

        if (agentArgs == null
                || "".equals(agentArgs)
                || handleConfMap.isEmpty()
                || handleConfMap.get("on") == null
                || (Boolean) handleConfMap.get("on")) {
            return actualHandle(classfileBuffer);
        }
        return classfileBuffer;
    }

    /**
     * 实际的处理方法
     *
     * @param classfileBuffer
     * @return
     */
    protected abstract byte[] actualHandle(byte[] classfileBuffer);


    //region 工具方法

    /**
     * method处理工具方法
     *
     * @param classfileBuffer
     * @param className
     * @param methodName
     * @param consumer
     * @param logTitle
     * @return
     */
    protected byte[] consumerMethod(byte[] classfileBuffer,
                                    String className,
                                    String methodName,
                                    Consumer<CtMethod> consumer,
                                    String logTitle) {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get(className);
            CtMethod[] declaredMethods = ctClass.getDeclaredMethods();
            for (CtMethod declaredMethod : declaredMethods) {
                if (Objects.equals(methodName, declaredMethod.getName())) {
                    consumer.accept(declaredMethod);
                    System.out.println(MessageFormat.format(LOG_PATTEN, logTitle, "加载成功"));
                    return ctClass.toBytecode();
                }
            }
        } catch (Exception e) {
            System.err.println(MessageFormat.format(LOG_PATTEN, logTitle, "加载失败"));
            e.printStackTrace();
        }
        return classfileBuffer;
    }

    protected interface Consumer<T> {
        void accept(T t) throws Exception;
    }

    //endregion

}
