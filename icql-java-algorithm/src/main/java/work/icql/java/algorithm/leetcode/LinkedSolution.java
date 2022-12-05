package work.icql.java.algorithm.leetcode;

import java.util.Objects;

public class LinkedSolution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
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
        if (head == null || k < 2) {
            return head;
        }
        int size = 1;
        ListNode newHead = null;
        boolean isFirstGroup = true;
        ListNode groupHead = head;
        ListNode lastGroupTail = null;
        while (head.next != null) {
            ListNode next = head.next;
            ListNode nextNext = next.next;
            if (size == k) {
                lastGroupTail = head;
                head = next;
                groupHead = next;
                size = 1;
                isFirstGroup = false;
                continue;
            }
            next.next = groupHead;
            groupHead = next;
            if (lastGroupTail != null) {
                lastGroupTail.next = groupHead;
            }
            if (isFirstGroup) {
                newHead = next;
            }
            head.next = nextNext;
            size++;
        }
        if (lastGroupTail != null && size < k) {
            ListNode newGroupHead = groupHead;
            while (groupHead.next != null) {
                ListNode next = groupHead.next;
                ListNode nextNext = next.next;
                next.next = newGroupHead;
                newGroupHead = next;
                groupHead.next = nextNext;
            }
            lastGroupTail.next = newGroupHead;
        }
        return newHead;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyP = dummy;

        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if (list1.val <= list2.val) {
                dummyP.next = list1;
                dummyP = dummyP.next;
                list1 = list1.next;
                continue;
            }
            dummyP.next = list2;
            dummyP = dummyP.next;
            list2 = list2.next;
        }
        while (Objects.nonNull(list1)) {
            dummyP.next = list1;
            dummyP = dummyP.next;
            list1 = list1.next;
        }
        while (Objects.nonNull(list2)) {
            dummyP.next = list2;
            dummyP = dummyP.next;
            list2 = list2.next;
        }
        return dummy.next;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy1P = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode dummy2P = dummy2;
        while (Objects.nonNull(head)) {
            if (head.val < x) {
                dummy1P.next = head;
                dummy1P = dummy1P.next;
            } else {
                dummy2P.next = head;
                dummy2P = dummy2P.next;
            }
            head = head.next;
            if (Objects.isNull(head)) {
                dummy1P.next = null;
                dummy2P.next = null;
            }
        }
        dummy1P.next = dummy2.next;

        return dummy1.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    public static void main(String[] args) {
        //ListNode head = new ListNode(3);
        //ListNode listNode2 = new ListNode(9);
        //ListNode listNode3 = new ListNode(6);
        //ListNode listNode4 = new ListNode(1);
        //ListNode listNode5 = new ListNode(1);
        //ListNode listNode6 = new ListNode(4);
        //ListNode listNode7 = new ListNode(7);
        //head.next = listNode2;
        //listNode2.next = listNode3;
        //listNode3.next = listNode4;
        //listNode4.next = listNode5;
        //listNode5.next = listNode6;
        //listNode6.next = listNode7;
        ////ListNode reverse = reverseList(head);
        ////ListNode rotateRight = rotateRight(head, 2);
        //ListNode listNode = reverseKGroup(head, 4);

        //ListNode list1 = new ListNode(1);
        //list1.next = new ListNode(2);
        //list1.next.next = new ListNode(4);
        //ListNode list2 = new ListNode(1);
        //list2.next = new ListNode(3);
        //list2.next.next = new ListNode(4);
        //ListNode listNode = mergeTwoLists(list1, list2);

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(2);
        list1.next.next.next.next = new ListNode(5);
        list1.next.next.next.next.next = new ListNode(2);
        ListNode partition = partition(list1, 3);

        System.out.println("end");
    }
}
