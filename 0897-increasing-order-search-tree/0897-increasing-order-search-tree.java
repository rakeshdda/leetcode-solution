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
        inOrder(root, queue);
        TreeNode newroot = queue.peek();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = null;
            node.right = queue.peek();
        }
        return newroot;
    }

    public void inOrder(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }

        inOrder(node.left, queue);
        queue.offer(node);
        inOrder(node.right, queue);
    }
}