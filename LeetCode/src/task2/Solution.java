package task2;

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
    ListNode result = new ListNode();
    ListNode head = new ListNode(0, result);
    ListNode tail = head;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        if (l1 != null && l2 != null) {
            sum = (result.val + l1.val + l2.val);
        } else if (l1 != null) {
            sum = (result.val + l1.val);
        } else if (l2 != null) {
            sum = (result.val + l2.val);
        } else {
            if (tail.next.val == 0) {
                tail.next = null;
            }
            return head.next;
        }
        result.val = sum % 10;
        result.next = new ListNode(0);
        result = result.next;
        tail = tail.next;
        if (sum >= 10) {
            result.val = sum / 10;
        }
        return addTwoNumbers(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode a7 = new ListNode(9);
        ListNode a6 = new ListNode(9, a7);
        ListNode a5 = new ListNode(9, a6);
        ListNode a4 = new ListNode(9, a5);
        ListNode a3 = new ListNode(9, a4);
        ListNode a2 = new ListNode(9, a3);
        ListNode a1 = new ListNode(9, a2);

        ListNode b4 = new ListNode(9);
        ListNode b3 = new ListNode(9, b4);
        ListNode b2 = new ListNode(9, b3);
        ListNode b1 = new ListNode(9, b2);

        System.out.println(solution.addTwoNumbers(b1, a1));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

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