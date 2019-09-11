package work.icql.java.datastructureold;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/6 11:47
 * @Title List
 * @Description 线性结构
 */
public interface List<T> {
    /**
     * 读取
     *
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 插入
     *
     * @param index
     * @param t
     * @return
     */
    boolean add(int index, T t);

    /**
     * 删除
     *
     * @param index
     * @return
     */
    boolean remove(int index);

    /**
     * 替换
     *
     * @param index
     * @param t
     * @return
     */
    boolean set(int index, T t);

    int size();
}
