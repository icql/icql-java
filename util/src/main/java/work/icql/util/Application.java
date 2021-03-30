package work.icql.util;

import java.lang.reflect.Proxy;

public class Application {

    public static void main(String[] args) throws Exception {
        TestService testService = new TestServiceImpl();
        TestService o = (TestService) Proxy.newProxyInstance(TestService.class.getClassLoader(),
                testService.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    System.out.println("执行前");
                    Object invoke = method.invoke(testService, args1);
                    System.out.println("执行后");
                    return invoke;
                }
        );
        o.test();
        //PdfMergeUtils.merge("C:\\Users\\Casstime\\Desktop\\", "C:\\Users\\Casstime\\Desktop");
    }

    public interface TestService {
        void test();
    }

    public static class TestServiceImpl implements TestService {
        @Override
        public void test() {
            System.out.println("test");
        }
    }
}