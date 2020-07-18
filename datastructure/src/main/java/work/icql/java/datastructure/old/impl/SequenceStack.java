package work.icql.java.datastructure.old.impl;


import work.icql.java.datastructure.old.List;
import work.icql.java.datastructure.old.Stack;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/18 17:24
 * @Title SequenceStack
 * @Description 线性结构——栈（顺序表实现）
 */
public class SequenceStack<T> implements Stack<T> {
    private List<T> list = new SequenceList<>();

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
