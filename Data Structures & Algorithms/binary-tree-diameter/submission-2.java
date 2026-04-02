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
    public int cal_len(TreeNode root,int[] max_depth){
        if (root==null) return 0;
        int left = cal_len(root.left,max_depth);
        int right = cal_len(root.right,max_depth);
        max_depth[0] = Math.max(max_depth[0],left+right);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        cal_len(root,arr);
        return arr[0];      
    }
}
