package work.icql.java.designpattern.creational.singleton;


/**
 * @author icql
 * @version 1.0
 * @date 2019/1/12 13:54
 * @Title 单例：饥饿模式——类加载时就创建对象，过早占用内存，存在性能问题
 * @Description EagerSingleton
 */
public final class EagerSingleton {
    /**
     * 类加载的时候执行clinit()时将创建对象，线程安全
     */
    private static EagerSingleton instance = new EagerSingleton();

    /**
     * 私有化构造方法
     */
    private EagerSingleton() {
    }

    /**
     * 获取单例
     *
     * @return
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}
