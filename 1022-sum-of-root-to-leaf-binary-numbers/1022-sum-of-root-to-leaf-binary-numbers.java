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
     public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0,0);
    }
    public int helper(TreeNode root, int num, int sum){
    	if(root == null){
    		return 0;
    	}
    	
    	num =num*2 + root.val;
    	
    	
    	if(root.left == null && root.right == null){
            
    		sum += num;
    		return sum;
    	}
    	
    	return helper(root.left , num, sum)  + helper(root.right, num, sum);
    }
}