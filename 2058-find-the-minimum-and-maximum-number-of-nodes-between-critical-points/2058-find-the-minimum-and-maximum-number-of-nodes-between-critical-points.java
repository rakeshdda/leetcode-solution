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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        

        ListNode prev = head;
        ListNode node = head.next;

        int length = 2;

        while (node.next != null) {

            if (node.val < prev.val && node.val < node.next.val) {
                list.add(length);
            } else if (node.val > prev.val && node.val > node.next.val) {
                list.add(length);
            }

            prev = node;
            node = node.next;
            length++;
        }

        int[] ans = new int[2];

        if (list.size() < 2) {
            return new int[] { -1, -1 };
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);

            minDiff = Math.min(minDiff, diff);
        }

        ans[0] = minDiff;

        ans[1] = list.get(list.size() - 1) - list.get(0);

        return ans;
    }
}