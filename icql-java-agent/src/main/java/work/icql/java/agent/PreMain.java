package work.icql.java.agent;


import work.icql.java.agent.transformer.HandlerTransformer;

import java.lang.instrument.Instrumentation;

public class PreMain {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new HandlerTransformer(agentArgs));
    }

    public static void premain(String agentArgs) {
    }
}
