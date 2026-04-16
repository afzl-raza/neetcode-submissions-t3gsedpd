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
    public int find_maxPathSum(TreeNode root,int[] max){
        if(root==null){
            return 0;
        }
        int left = find_maxPathSum(root.left,max);
        left = Math.max(left,0);
        int right = find_maxPathSum(root.right,max);
        right = Math.max(right,0);
        max[0] = Math.max(max[0],root.val+left+right);
        return (root.val+Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] max =new int[1];
        max[0] = Integer.MIN_VALUE;
        int curr = find_maxPathSum(root,max);
        return max[0];   
    }
}
