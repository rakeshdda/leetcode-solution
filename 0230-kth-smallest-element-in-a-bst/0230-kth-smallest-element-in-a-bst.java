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
    int count =0;
    int ans =-1;
    public int kthSmallest(TreeNode root, int k) {
        Inorder(root, k);
        return ans;

        

       
    //     ArrayList<Integer> list = new ArrayList<>();

    //     Inorder(root, list);

    //     return list.get(k-1);
    // }
    // public void Inorder(TreeNode root, ArrayList<Integer> list){
    //     if(root== null){
    //         return ;
    //     }

    //     Inorder(root.left, list);
    //     list.add(root.val);
    //     Inorder(root.right, list);
    }

    public void Inorder(TreeNode root, int k){
        if(root == null){
            return ;
        }

        Inorder(root.left, k);

        count++;
        if(count == k){
            ans = root.val;
            return;
        }

        Inorder(root.right, k);
    }
}