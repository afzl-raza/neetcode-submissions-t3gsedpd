class Solution {
    public boolean wordBreak(String s,Set<String> wordDict,int i,int[]dp){
        if(i==s.length()){
            return true;
        }
        if(dp[i]!=-1){
            return dp[i]==1;
        }
        for (int j=i;j<s.length();j++){
            String word = s.substring(i,j+1);
            if(wordDict.contains(word)&&wordBreak(s,wordDict,j+1,dp)){
                dp[i] =1;
                return true;
            }
        }
        dp[i]=0;
        return false;
        
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> nWordDict = new HashSet<>(wordDict);
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return wordBreak(s,nWordDict,0,dp);
        
    }
}
