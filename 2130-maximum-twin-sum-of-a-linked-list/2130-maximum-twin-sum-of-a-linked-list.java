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
    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack();

        int max =Integer.MIN_VALUE;
        int n = length(head);
        ListNode node = head;

        for(int i=0; i <= (n/2)-1 ; i++){
            stack.push(node.val);
            node= node.next;
        }

        while(node != null){
            int sum =0;
            int twin= stack.pop();

            sum = node.val + twin;
            max = Math.max(max, sum);
            node = node.next;
        }

        return max;

    }
    public int length(ListNode head){
    int count =0;
    ListNode node = head;

    while(node !=null){
        count++;
        node= node.next;
    }
    return count;
    }
}