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
    public boolean isSymmetric(TreeNode root) {

    //Bfs
    //    Queue<TreeNode> queue = new LinkedList<>();
    //    queue.add(root.left);
    //    queue.add(root.right);

    //    while(!queue.isEmpty()){
    //     TreeNode left = queue.poll();
    //     TreeNode right = queue.poll();

    //     if(left == null && right ==null){
    //         continue;
    //     }
    //     if(left == null || right == null ){
    //         return false;
    //     }
    //     if(left.val != right.val){
    //         return false;
    //     }

    //     queue.add(left.left);
    //     queue.add(right.right);
    //     queue.add(left.right);
    //     queue.add(right.left);
    //    } 
    //    return true;


    // recursive
    if(root==null){
        return true;
    }

    return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null ){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}