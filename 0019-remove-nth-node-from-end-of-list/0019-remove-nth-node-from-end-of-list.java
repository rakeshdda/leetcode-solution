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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }

        ListNode preNth = nthNode(head, n);
            if(preNth == null){
                return head.next;
            }
        preNth.next =  preNth.next.next;

        return head;
        
    }
    //this methode give prev node of the nth node from the last
    public ListNode nthNode(ListNode head, int n){
        ListNode first = head;
        ListNode second = head;

        for(int i =0; i<= n; i++){
            if(first == null){
                return null;
            }
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second= second.next;
        }
        return second;
    }
}

