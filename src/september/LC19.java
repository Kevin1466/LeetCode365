package src.september;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LC19 {
    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(22);
//        ListNode node3 = new ListNode(33);
//        ListNode node4 = new ListNode(44);
        headNode.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        removeNthFromEnd(headNode, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int listSize = 0;
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        ListNode headCopy = new ListNode(0);
        headCopy.next = head.next;
        nodeMap.put(listSize, head);
        while (headCopy.next != null) {
            listSize++;
            headCopy = headCopy.next;
            nodeMap.put(listSize, headCopy);
        }

        ListNode indexNode = new ListNode(0);
        ListNode resultNode = new ListNode(0);
        for (Map.Entry<Integer, ListNode> entry: nodeMap.entrySet()) {
            // delete
            if (entry.getKey() != listSize-n+1) {
                indexNode.next = entry.getValue();
                indexNode = indexNode.next;
            }
            if (entry.getKey() == 0) {
                resultNode = indexNode;
            }
            if (listSize == entry.getKey()+1) {
                indexNode.next = null;
            }
        }
        return resultNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
