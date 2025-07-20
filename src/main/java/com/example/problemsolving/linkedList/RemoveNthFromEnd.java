package com.example.problemsolving.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;

    }
}