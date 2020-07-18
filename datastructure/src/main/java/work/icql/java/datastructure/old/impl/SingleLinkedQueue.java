package work.icql.java.datastructure.old.impl;

import work.icql.java.datastructure.old.List;
import work.icql.java.datastructure.old.Queue;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/19 9:20
 * @Title SingleLinkedQueue
 * @Description 线性结构——队列（单链表实现）
 */
public class SingleLinkedQueue<T> implements Queue<T> {
    private List<T> list = new SingleLinkedList<>();

    @Override
    public boolean add(T t) {
        return list.add(list.size(), t);
    }

    @Override
    public T remove() {
        T t = list.get(0);
        list.remove(0);
        return t;
    }

    @Override
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }
}
