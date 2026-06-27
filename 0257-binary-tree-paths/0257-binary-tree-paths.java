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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
         StringBuilder sb = new StringBuilder();

        helper(root, list,sb);
        return list;
    }
   
    public void helper(TreeNode root, List<String> list, StringBuilder sb){
        if(root == null){
            return;
        }

        

        if(root.left == null && root.right == null){
            sb.append(root.val);
            list.add(sb.toString());
        }
        sb.append(root.val + "->");
        
        helper(root.left, list, new StringBuilder(sb));
        helper(root.right, list, new StringBuilder(sb));
    }
}