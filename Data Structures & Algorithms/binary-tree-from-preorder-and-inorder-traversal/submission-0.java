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
    Map<Integer,Integer> in_map = new HashMap<>();
    public TreeNode build_tree(int[] preorder,int p_start,int p_end,int i_start,int i_end){
        if(p_start>p_end || i_start>i_end){
            return null;
        }
        int rootval = preorder[p_start];
        TreeNode root = new TreeNode(rootval);
        int inroot_indx = in_map.get(rootval);
        int left_size = inroot_indx-i_start;
        root.left = build_tree(preorder,p_start+1,p_start+left_size,i_start,inroot_indx-1);
        root.right = build_tree(preorder,p_start+left_size+1,p_end,inroot_indx+1,i_end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++){
            in_map.put(inorder[i],i);
        }
        return build_tree(preorder,0,preorder.length-1,0,inorder.length-1);
        
    }
}
