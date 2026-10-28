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
    public void insert(TreeNode root, int val){
        if(root==null) return ;
        if(root.left==null && root.val>val){
            root.left = new TreeNode(val);
        }
        if (root.right==null && root.val<val){
            root.right = new TreeNode(val);
        }
        if(root.right!=null && root.val<val){
            insert(root.right,val);
        }
        if(root.left!=null && root.val>val){
            insert(root.left,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        insert(root,val);
        return root;
        
    }
}