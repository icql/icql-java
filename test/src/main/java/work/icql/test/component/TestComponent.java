package work.icql.test.component;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestComponent implements ApplicationListener<ApplicationReadyEvent>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        String[] beanNamesForType = this.applicationContext.getBeanNamesForType(TestController.class);
        Object testController = this.applicationContext.getBean("testController");
        System.out.println("test");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
