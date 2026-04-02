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
    public int  maxCount(TreeNode root){
        if (root==null){
            return 0;
        }
        int left_c = maxCount(root.left);
        int right_c = maxCount(root.right);
        return Math.max(left_c,right_c)+1;
    }
    public int maxDepth(TreeNode root) {
        return maxCount(root);    
    }
}
