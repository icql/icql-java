package work.icql.java.agent.transformer.handler;

public class DefaultHandler extends AbstractHandler {

    public DefaultHandler(String agentArgs) {
        super(agentArgs);
    }

    @Override
    public byte[] actualHandle(byte[] classfileBuffer) {
        return classfileBuffer;
    }
}
