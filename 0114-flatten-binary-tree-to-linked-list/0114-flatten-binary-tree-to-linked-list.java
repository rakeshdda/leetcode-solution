/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {

        //normal preorder.  extra space O(n)
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     preOrder(root, queue);

    //     while (!queue.isEmpty()) {
    //         TreeNode node = queue.poll();
    //         node.left = null;
    //         node.right = queue.peek();
    //     }
    // }

    // public void preOrder(TreeNode node, Queue<TreeNode> queue) {
    //     if (node == null) {
    //         return;
    //     }

    //     queue.offer(node);
    //     preOrder(node.left, queue);
    //     preOrder(node.right, queue);




     //O(1) space 
    TreeNode current = root;
    while(current != null){
        if(current.left != null){
            TreeNode temp = current.left;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = current.right;
            current.right = current.left;
            current.left = null;
        }
        current = current.right;
    }

    // 1)take a movable pointer at the root as cuurent;
    // 2) while current != null check if the the left subtree of current is not null , if not then find the rightmost node of the left subtree . let say x
    // 3) then connect the right subtree of current as the right of the right most node in the left subtree (example as x.right) 
    // 4) then make the left subtree of current as right, and make the left null, current.left = null
    // 5) finally move your current to next right node to do the same

    }
}