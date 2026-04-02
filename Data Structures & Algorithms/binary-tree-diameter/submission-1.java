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
    public int cal_len(TreeNode root){
        if (root==null) return 0;
        int left = cal_len(root.left);
        int right = cal_len(root.right);
        return Math.max(left,right)+1;
    }
    public int  traverse_tree(TreeNode root,int[] max_depth){
        if (root==null){
            return 0;
        }
        int left = cal_len(root.left);
        int right = cal_len(root.right);
        max_depth[0] = Math.max(max_depth[0],left+right);
        traverse_tree(root.left,max_depth);
        traverse_tree(root.right,max_depth);
        return max_depth[0];
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return traverse_tree(root,new int[1]);       
    }
}
