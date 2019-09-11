package work.icql.java.datastructureold.impl;

import work.icql.java.datastructureold.List;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/6 11:49
 * @Title SequenceList
 * @Description 线性结构（顺序存储）
 */
public class SequenceList<T> implements List<T> {
    //当前长度
    private int length;
    //存储空间容量，初始值为10
    private int maxSize = 10;
    //存储空间
    private Object[] objectArray = new Object[this.maxSize];

    @Override
    public T get(int index) {
        if (!checkIndex(index))
            return null;
        return (T) objectArray[index];
    }

    @Override
    public boolean add(int index, T t) {
        if (!checkIndex(index))
            return false;
        if (this.length == this.maxSize) {
            growArray();
        }
        for (int i = this.length; i > index; i--) {
            objectArray[i] = objectArray[i - 1];
        }
        objectArray[index] = t;
        this.length++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (!checkIndex(index))
            return false;
        for (int i = index; i < this.length; i++) {
            objectArray[i] = objectArray[i + 1];
        }
        this.length--;
        return true;
    }

    @Override
    public boolean set(int index, T t) {
        if (!checkIndex(index))
            return false;
        objectArray[index] = t;
        return true;
    }

    @Override
    public int size() {
        return this.length;
    }

    private void growArray() {
        Object[] srcArray = objectArray;
        int length = srcArray.length + (srcArray.length >> 1);
        objectArray = new Object[length];
        System.arraycopy(srcArray, 0, objectArray, 0, srcArray.length);
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= this.length + 1)
            return false;
        return true;
    }
}
