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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "N,";
        }
        StringBuilder sb = new StringBuilder();
        String left = serialize(root.left);
        String right = serialize(root.right);
        sb.append(Integer.toString(root.val));
        sb.append(",");
        sb.append(left);
        sb.append(right);
        return sb.toString();   
    }

    // Decodes your encoded data to tree.
    int i = 0;
    public TreeNode deserialize_data(String[] data){
        if(i>=data.length){
            return null;    
        }
        String curr =data[i];
        i++;
        if(curr.equals("N")){
            return null;    
        }
        else{
            TreeNode root = new TreeNode(Integer.parseInt(curr));
            TreeNode left = deserialize_data(data);
            TreeNode right = deserialize_data(data);
            root.left = left;
            root.right = right;
            return root;
        }
        
    }
    public TreeNode deserialize(String data) {
        String[] new_data = data.split(",");
        return deserialize_data(new_data);
        
        
    }
}
