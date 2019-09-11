package work.icql.java.concurrent;

/**
 * @author icql
 * @version 1.0
 * @date 2019/7/10 20:30
 * @Title LinkedList
 * @Description LinkedList
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if (index == 0)
            addFirst(e);
        else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;

            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        return res.toString();
    }

    public Node reverse(Node head) {
        Node tempHead = head;
        if (tempHead == null) {
            return head;
        }
        Node tempTail = head.next;
        if (tempTail == null) {
            return head;
        }
        Node tempTailNext = head.next.next;

        tempTail.next = tempHead;
        head.next = reverse(tempTailNext);
        return tempTail;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ls = new LinkedList<>();
        ls.addLast(1);
        ls.addLast(2);
        ls.addLast(3);
        ls.addLast(4);
        ls.addLast(5);
        ls.addLast(6);

        ls.head = ls.reverse(ls.head);
        System.out.println(ls);
    }
}
