package work.icql.java.algorithm.a_link;

import java.util.Objects;

public class Link_0206_reverseList {
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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        while (head.next != null) {
            ListNode next = head.next;
            ListNode nextNext = next.next;
            next.next = newHead;
            newHead = next;
            head.next = nextNext;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Link_0206_reverseList link = new Link_0206_reverseList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode ret = link.reverseList(l1);
        ret.traverse();

        System.out.println();
    }
}
