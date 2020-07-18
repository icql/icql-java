package work.icql.java.datastructure.old;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/18 17:19
 * @Title Stack
 * @Description 特殊的线性结构：栈
 */
public interface Stack<T> {
    /**
     * 入栈
     *
     * @param t
     * @return
     */
    boolean push(T t);

    /**
     * 出栈
     *
     * @return
     */
    T pop();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
