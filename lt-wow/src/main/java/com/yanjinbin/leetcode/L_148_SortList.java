package com.yanjinbin.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class L_148_SortList {

    public ListNode sortList(ListNode head) {
        String s = new String();
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortList(head), sortList(right));
    }

    /**
     * 获取链表的中间结点,偶数时取中间第一个
     *
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     *
     * 归并两个有序的链表
     *
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, head;
        //得到头节点的指向
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        //比较链表中的值
        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        //第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        //第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }
}