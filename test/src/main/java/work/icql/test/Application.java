package work.icql.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import work.icql.test.service.TestService;
import work.icql.test.service.TestServiceImpl;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestServiceImpl testService = applicationContext.getBean("testService", TestServiceImpl.class);
        testService.test();
    }
}
