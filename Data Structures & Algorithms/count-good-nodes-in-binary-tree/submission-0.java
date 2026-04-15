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
    public void count_good(TreeNode root,int[]count,int max){
        if (root==null){
            return;
        }
        max = Math.max(root.val,max);
        if(root.val>=max){
            count[0]++;
        }
        count_good(root.left,count,max);
        count_good(root.right,count,max);
    }
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        count_good(root,count,Integer.MIN_VALUE);
        return count[0];
        
    }
}
