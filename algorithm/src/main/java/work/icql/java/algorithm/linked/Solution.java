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

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cursor = head;
        ListNode newHead = head;
        while (cursor.next != null) {
            ListNode nextNext = cursor.next.next;
            ListNode oldHead = newHead;
            newHead = cursor.next;
            newHead.next = oldHead;
            cursor.next = nextNext;
        }
        return newHead;
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


    public static ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null) {
//            return head;
//        }
//        ListNode lastCursor = head;
//        ListNode lastTail = null;
//        ListNode cursor = head;
//        int size = 1;
//        while (cursor.next != null) {
//            size++;
//            if (size == k) {
//                //反转
//                while (lastCursor.next != null) {
//                    ListNode next = lastCursor.next;
//                    //1.3,2.1
//
//                    lastCursor = next;
//                }
//
//                //lastTail = 1;
//            }
//            //连接
//            if (lastTail != null) {
//                lastTail.next
//            }
//            cursor = cursor.next;
//        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        head.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        ListNode reverse = reverseList(head);
        //ListNode rotateRight = rotateRight(head, 2);
        String re = "";
    }
}
