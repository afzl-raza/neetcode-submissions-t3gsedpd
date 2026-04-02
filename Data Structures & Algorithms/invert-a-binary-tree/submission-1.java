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
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return root;
        }

        else if (root.left!=null && root.right!=null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        else if (root.left!=null && root.right==null){
            root.right = root.left;
            root.left = null;
        }
        else if (root.left==null && root.right!=null){
            root.left = root.right;
            root.right = null;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
        
    }
}
