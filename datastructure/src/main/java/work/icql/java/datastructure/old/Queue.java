package work.icql.java.datastructure.old;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/19 9:14
 * @Title Queue
 * @Description 特殊的线性结构：队列
 */
public interface Queue<T> {
    /**
     * 入队
     *
     * @param t
     * @return
     */
    boolean add(T t);

    /**
     * 出队
     *
     * @return
     */
    T remove();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
