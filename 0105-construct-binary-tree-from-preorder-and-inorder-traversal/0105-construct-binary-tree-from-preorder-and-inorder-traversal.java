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
    int preIndex =0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder, inorder, 0, inorder.length-1);

    }
    public TreeNode helper(int [] preorder, int[] inorder, int left, int right){

        if(left > right){
            return null;
        }

        int rootval = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(rootval);

        int i =0;

        while(inorder[i] != root.val){
            i++;
        }

        root.left  = helper(preorder, inorder, left , i-1);
        root.right = helper(preorder, inorder, i+1,  right);

        return root; 
    }
}