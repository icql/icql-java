package work.icql.java.concurrent;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author icql
 * @version 1.0
 * @date 2019/5/25 20:57
 * @Title MyClassTest
 * @Description MyClassTest
 */
public class MyClassTest {

    private MyClass myClass = new MyClass();

    @Test
    public void sayHello() {
        Assert.assertEquals(2,myClass.sayHello());
    }
}