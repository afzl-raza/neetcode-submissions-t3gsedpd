class Solution {
    public void backTrack(int n, int i, int k, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        else if(curr.size()>k || i>n) return;
        curr.add(i);
        backTrack(n,i+1,k,curr, ans);
        curr.remove(curr.size()-1);
        backTrack(n,i+1,k,curr,ans);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(n,1,k,new ArrayList<>(), ans);
        return ans;
        
    }
}