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
   class Solution{
   	 public boolean isCousins(TreeNode root, int x, int y) {
        if(root  == null){
        return false;
        }
        
        if(level(root, x,0 ) == level(root, y, 0) && !sibling(root, x, y)){
        	return true;
        }
        
        return false;
    }
    public int level(TreeNode root, int key, int lev){
    	if(root == null){
    		return -1;
    	}
    	
    	if(root.val == key){
    		return lev;
    	}
    	
    	int left = level(root.left, key, lev +1);
    	if(left != -1){
    		return left;
    	}
    	
    	return level(root.right, key, lev+1);
    }
    
    public boolean sibling(TreeNode root, int x, int y){
    	if(root == null){
    		return false;
    	}

    	if(root.left != null && root.right != null){
    	if((root.left.val == x && root.right.val == y) || (root.left.val ==y && root.right.val == x)){
    		return true;
    	}
        }
    	
    	return sibling(root.left, x, y) || sibling(root.right, x, y);
    }
    
    
}