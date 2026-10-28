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
    private boolean helper(TreeNode root, int max, int min){
        if(root==null) return true;
        if(root.val> max || root.val<min) return false;
        return (root.val>min && root.val<max) && helper(root.left,root.val,min) && helper(root.right,max, root.val);
    }
    public boolean isValidBST(TreeNode root) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return helper(root, max,min);
        
    }
}
