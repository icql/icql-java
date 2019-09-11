package work.icql.java.designpattern.creational.singleton;


/**
 * @author icql
 * @version 1.0
 * @date 2019/1/12 14:18
 * @Title 单例：懒汉模式——延迟加载，同步范围过大，性能不佳
 * @Description LazySingleton
 */
public final class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    /**
     * 获取单例，同步方法，保证线程安全，但同步范围太大，性能不佳
     *
     * @return
     */
    public synchronized static LazySingleton getInstance() {
        if (instance != null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
