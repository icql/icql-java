package work.icql.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class TestServiceImpl implements TestService {

    @Autowired
    private ApplicationContext applicationContext;

    public void test() {
        System.out.println("输出test");
    }
}
