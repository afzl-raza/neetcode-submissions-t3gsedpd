class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int []nums,List<Integer> curr,int indx){
        if (indx>=nums.length){
            ans.add(List.copyOf(curr));
            return ;
        }
        curr.add(nums[indx]);
        helper(nums,curr,indx+1);
        curr.remove(curr.size()-1);
        helper(nums,curr,indx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,new ArrayList<Integer>(),0);
        return ans;
        
    }
}
