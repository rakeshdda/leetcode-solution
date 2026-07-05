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
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b) -> a.val -b.val);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for(int i =0; i< lists.length; i++){
            if(lists[i] != null){
                minheap.offer(lists[i]);
            }
        }

        while(!minheap.isEmpty()){
           ListNode current = minheap.poll();

           temp.next = current;
           temp = temp.next;

           if(current.next != null){
            minheap.offer(current.next);
           }
        }
        return dummy.next;
    }
}