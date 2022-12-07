package work.icql.java.algorithm.a_link;

import java.util.Objects;

public class Link_0061_rotateRight {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void traverse() {
            System.out.println();
            System.out.print("开始 -> ");
            ListNode pointer = this;
            while (Objects.nonNull(pointer)) {
                System.out.print(pointer.val + " -> ");
                pointer = pointer.next;
            }
            System.out.print("结束");
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k < 0 || head == null) {
            return head;
        }
        //遍历第1遍拿到size
        int size = 1;
        ListNode cursor = head;
        while (cursor.next != null) {
            size++;
            cursor = cursor.next;
        }
        //计算最小的k
        int minK = k % size;
        if (minK == 0) {
            return head;
        }
        //两个需要处理的结点
        //1）原链表的最后一个结点
        //2）返回链表的最后一个结点
        ListNode originLastNode = cursor;
        int resultEndIndex = size - minK - 1;
        ListNode resultEndNode = null;
        cursor = head;
        for (int index = 0; index < size; index++) {
            if (index == resultEndIndex) {
                resultEndNode = cursor;
                break;
            }
            cursor = cursor.next;
        }
        ListNode newHead = resultEndNode.next;
        resultEndNode.next = null;
        originLastNode.next = head;
        return newHead;
    }


    public static void main(String[] args) {
        Link_0061_rotateRight link = new Link_0061_rotateRight();

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(4);

        ListNode ret = link.rotateRight(l1, 2);
        ret.traverse();

        System.out.println();
    }
}
