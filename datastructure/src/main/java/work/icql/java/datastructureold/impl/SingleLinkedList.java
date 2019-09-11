package work.icql.java.datastructureold.impl;


import work.icql.java.datastructureold.List;

/**
 * @author icql
 * @version 1.0
 * @date 2018/12/18 13:22
 * @Title SingleLinkedList
 * @Description 线性结构——单链表（链式存储）
 */
public class SingleLinkedList<T> implements List<T> {
    private int length;
    private Node head;

    public SingleLinkedList() {
        this.length = 0;
        head = new Node(this.length, null);
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.data = item;
            this.next = next;
        }
    }

    @Override
    public T get(int index) {
        if (!checkIndex(index))
            return null;
        return node(index).data;
    }

    @Override
    public boolean add(int index, T t) {
        if (!checkIndex(index))
            return false;
        Node<T> node = node(index);
        T old = node.data;
        Node<T> nextNode = node.next;
        node.data = t;
        node.next = new Node(old, nextNode);
        this.length++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (!checkIndex(index))
            return false;
        Node<T> node = node(index);
        node.data = node.next.data;
        node.next = node.next.next;
        this.length--;
        return true;
    }

    @Override
    public boolean set(int index, T t) {
        if (!checkIndex(index))
            return false;
        Node<T> node = node(index);
        node.data = t;
        return true;
    }

    @Override
    public int size() {
        return this.length;
    }

    private Node<T> node(int index) {
        Node<T> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= this.length + 1)
            return false;
        return true;
    }
}
