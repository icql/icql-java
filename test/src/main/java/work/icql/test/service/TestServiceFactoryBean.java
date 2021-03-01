package work.icql.test.service;

import org.springframework.beans.factory.FactoryBean;

public class TestServiceFactoryBean implements FactoryBean<TestService> {

    public boolean isSingleton() {
        return false;
    }

    public TestService getObject() throws Exception {
        return null;
    }

    public Class<?> getObjectType() {
        return null;
    }
}
