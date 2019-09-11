package work.icql.java.designpattern.creational.singleton;


/**
 * @author icql
 * @version 1.0
 * @date 2019/1/12 14:41
 * @Title 内部类实现懒加载
 * @Description InnerClassSingleton
 */
public final class InnerClassSingleton {
    private InnerClassSingleton() {
    }

    /**
     * 内部类实现懒加载
     */
    private static class SingletonHolder {
        public final static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
