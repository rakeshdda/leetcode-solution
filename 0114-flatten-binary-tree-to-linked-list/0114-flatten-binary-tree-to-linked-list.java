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
        Queue<TreeNode> queue = new LinkedList<>();
		preOrder(root, queue );
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			node.left = null;
			node.right= queue.peek();
		}        
    }
    public void preOrder(TreeNode node, Queue<TreeNode> queue){
          if(node == null){
        	return;
        }
        
        queue.offer(node);
        preOrder(node.left, queue);
        preOrder(node.right, queue);
    }
}