package task21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode current = new ListNode();
        ListNode head = current;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current.next.next = null;
            current = current.next;
        }

        while (node1 != null) {
            current.next = node1;
            node1 = node1.next;
            current.next.next = null;
            current = current.next;
        }

        while (node2 != null) {
            current.next = node2;
            node2 = node2.next;
            current.next.next = null;
            current = current.next;
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        ListNode a4 = new ListNode(4);
//        ListNode a2 = new ListNode(2, a4);
//        ListNode a1 = new ListNode(1, a2);
//
//        ListNode b4 = new ListNode(4);
//        ListNode b3 = new ListNode(3, b4);
//        ListNode b1 = new ListNode(1, b3);
//
//        System.out.println(solution.mergeTwoLists(a1, b1));
//    }