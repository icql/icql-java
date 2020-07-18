package work.icql.java.designpattern.creational.singleton;


/**
 * @author icql
 * @version 1.0
 * @date 2019/1/12 14:23
 * @Title 单例：双重检查锁
 * @Description 初始化对象的3个步骤：
 * 1）分配内存空间
 * 2）初始化对象
 * 3）将内存空间的地址赋值给对应的引用
 * 由于虚拟机有指令重排优化机制，上述步骤可能会变为 1-3-2，所以需要 volatile 关键字来保证禁止重排指令，
 * 如果以1-3-2顺序执行，线程A运行到第2次检查通过后正在初始化对象，初始化对象需要一定时间，这时步骤已完成1和3，
 * 线程B运行到第1次检查发现不为null，则直接返回，实际上 线程A还没有完成初始化对象的步骤2，造成了jvm异常
 */
public final class DoubleCheckedSingleton {

    private volatile static DoubleCheckedSingleton INSTANCE;

    private DoubleCheckedSingleton() {
    }

    /**
     * 获取单例
     */
    public static DoubleCheckedSingleton getInstance() {
        //第1次检查
        if (INSTANCE != null) {
            synchronized (DoubleCheckedSingleton.class) {
                //第2次检查
                if (INSTANCE != null) {
                    INSTANCE = new DoubleCheckedSingleton();
                }
            }
        }
        return INSTANCE;
    }
}