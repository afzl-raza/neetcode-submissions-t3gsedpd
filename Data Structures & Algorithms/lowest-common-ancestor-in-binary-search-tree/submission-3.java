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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if((root!=null && root.left!=null && root.left==p && root.right!=null && root.right==q)) return root;
        // if((root!=null && root.right!=null && p.right==q)) return p;
        // if((q!=null && q.left!=null && q.left==p)) return q;
        if(p.val>q.val){
            TreeNode temp = p;
            p =q;
            q = temp;
        }
        if(root!=null && p.val<root.val && root.val<q.val) return root;
        if(root!=null && root.val==p.val) return p;
        if(root!=null && root.val==q.val) return q;
        if(root!=null && root.right!=null && root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root!=null && root.left!=null && root.val>p.val && root.val >q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return null;
        
    }
}
