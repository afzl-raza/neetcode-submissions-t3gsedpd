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
    boolean helper(TreeNode root,int min,int max){
        if (root==null){
            return true;
        }
        return (root.val<max && root.val>min)
        && helper(root.left,min,root.val)
        && helper(root.right,root.val,max);        
    }

    public boolean isValidBST(TreeNode root) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return helper(root,min,max);
    }
}
