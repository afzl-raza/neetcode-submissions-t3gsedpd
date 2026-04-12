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
    public int cal_height(TreeNode root){
        if ( root==null){
            return 0;
        }
        int left  = cal_height(root.left);
        int right = cal_height(root.right);
        return (Math.max(left,right)+1);
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            int left = curr.left!=null?cal_height(curr.left):0;
            int right = curr.right!=null?cal_height(curr.right):0;
            int diff = left-right;
            if(diff>1 || diff<-1){
                return false;
            }
            if(curr.left!=null){
                s.push(curr.left);
            }
            if(curr.right!=null){
                s.push(curr.right);
            }
        }
        return true;    
    }
}
