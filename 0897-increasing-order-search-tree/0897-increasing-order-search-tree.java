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
    public TreeNode increasingBST(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root, queue);
        TreeNode newroot = queue.peek();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = null;
            node.right = queue.peek();
        }
        return newroot;
    }

    public void preOrder(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }

        preOrder(node.left, queue);
        queue.offer(node);
        preOrder(node.right, queue);
    }
}