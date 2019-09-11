package work.icql.java.datastructureold.impl;


import work.icql.java.datastructureold.List;
import work.icql.java.datastructureold.Stack;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/18 17:33
 * @Title SingleLinkedStack
 * @Description 线性结构——栈（单链表实现）
 */
public class SingleLinkedStack<T> implements Stack<T> {
    private List<T> list = new SingleLinkedList<>();

    @Override
    public boolean push(T t) {
        return list.add(list.size(), t);
    }

    @Override
    public T pop() {
        int size = list.size();
        T t = list.get(size - 1);
        list.remove(size - 1);
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
