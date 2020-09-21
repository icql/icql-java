package work.icql.java.algorithm.linked;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * TODO
     *
     * @param head
     */
    public void reverse(ListNode head) {
        //遍历第1遍拿到size
        int size = 1;
        ListNode cursor = head;
        while (cursor.next != null) {
            size++;
            cursor = cursor.next;
        }
        cursor = head;
        for (int index = 0; index < size; index++) {
            ListNode oldHead = head;
            ListNode oldNext = cursor.next;
            if (oldNext != null) {
                cursor.next = oldNext.next;
                head = oldNext;
                head.next = oldHead;
            }
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
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
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = rotateRight(head, 2);
        String re = "";
    }
}
