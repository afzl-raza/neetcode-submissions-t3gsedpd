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
    public int find_maxPathSum(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = find_maxPathSum(root.left);
        left = Math.max(left,0);
        int right = find_maxPathSum(root.right);
        right = Math.max(right,0);
        return (root.val+Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max =Integer.MIN_VALUE;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            int left = Math.max(0,find_maxPathSum(temp.left));
            int right = Math.max(0,find_maxPathSum(temp.right));
            int curr = temp.val+left+right;
            max = Math.max(curr,max);
            if(temp.left!=null){
                q.offer(temp.left);
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }
        }
        return max;   
    }
}
