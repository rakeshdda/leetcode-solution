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

       TreeNode dummy = new TreeNode(-1);
       TreeNode prev = dummy;
    public TreeNode increasingBST(TreeNode root) {
        //      Queue<TreeNode> queue = new LinkedList<>();
        //     inOrder(root, queue);
        //     TreeNode newroot = queue.peek();
        //     while (!queue.isEmpty()) {
        //         TreeNode node = queue.poll();
        //         node.left = null;
        //         node.right = queue.peek();
        //     }
        //     return newroot;
        // }

        // public void inOrder(TreeNode node, Queue<TreeNode> queue) {
        //     if (node == null) {
        //         return;
        //     }

        //     inOrder(node.left, queue);
        //     queue.offer(node);
        //     inOrder(node.right, queue);

        inorder(root);
        return dummy.right;
    }
    public void inorder(TreeNode node){
        if (node == null) {
            return;
        }

        inorder(node.left);

        prev.right = node;
        node.left = null;
        prev = node;

        inorder(node.right);
    }
}