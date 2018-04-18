package LeetCoding;

import java.util.LinkedList;
import java.util.List;

public class RemoveLinkedListElements {
    public static void main(String[] args) {

        ListNode node0 = new ListNode(1);

        ListNode node1 = new ListNode(1);
        node0.next = node1;

        ListNode node2 = new ListNode(1);
        node1.next = node2;

        ListNode node3 = new ListNode(1);
        node2.next = node3;

//
//        ListNode node5 = new ListNode(5);
//        node4.next = node5;
//
//        ListNode node6 = new ListNode(6);
//        node5.next = node6;

        ListNode listNode = removeElements(node0, 1);

        while (true) {
            if (listNode != null) {
                System.out.print(listNode.val + " ");
            } else {
                break;
            }
            listNode = listNode.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode pointer = new ListNode(Integer.MIN_VALUE);
        pointer.next = head;
        while (pointer != null && pointer.next != null) {
            if (head.val == val) {
                head = head.next;
                pointer = pointer.next;
            } else {
                ListNode temp = pointer.next;
                if (temp.val == val) {
                    pointer.next = temp.next;
                    temp = null;
                } else {
                    pointer = pointer.next;
                }
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
