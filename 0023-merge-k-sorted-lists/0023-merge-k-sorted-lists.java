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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b)-> a.val -b.val);
       
       for(int i =0; i< lists.length; i++){
            if(lists[i] != null){
                minheap.offer(lists[i]);
            }
        }

       ListNode dummy = new ListNode(-1);
       ListNode temp= dummy;

       while(!minheap.isEmpty()){
        ListNode curr =minheap.poll();

        temp.next = curr;
        temp = temp.next;

        if(curr.next != null){
            minheap.offer(curr.next);
        }
       }

       return dummy.next;

    }
}