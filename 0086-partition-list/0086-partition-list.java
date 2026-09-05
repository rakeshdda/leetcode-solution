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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyS= new ListNode(-1);
        ListNode node1 = dummyS;

        ListNode dummyG = new ListNode(-1);
        ListNode node2 = dummyG;

        ListNode temp = head;
        while(temp != null){

            if(temp.val < x){
                node1.next = temp;

                node1= node1.next;
            }else if(temp.val>= x){
                node2.next = temp;

                node2= node2.next;
            }

             temp = temp.next;
        }
        node2.next = null;
        node1.next =dummyG.next;

        return dummyS.next;
    }
    }