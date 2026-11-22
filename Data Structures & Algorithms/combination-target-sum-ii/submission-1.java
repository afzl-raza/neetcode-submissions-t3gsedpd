class Solution {
    public void backTrack(int[] candidates, int target, int i, List<Integer> curr, Set<List<Integer>> ans, int sum){
        if(sum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        else if(sum>target || i>=candidates.length) return;
        for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j]==candidates[j-1]) continue;
            curr.add(candidates[j]);
            backTrack(candidates, target, j+1, curr, ans, sum+candidates[j]);
            curr.remove(curr.size()-1);
        // backTrack(candidates,target,i+1,curr,ans,sum);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> ans = new HashSet<>();
        backTrack(candidates, target,0,new ArrayList<>(),ans,0);
        return new ArrayList<>(ans);
        
    }
}
