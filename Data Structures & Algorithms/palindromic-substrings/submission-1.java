class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        boolean[][] dp = new boolean[n][n];
        int count=0;
        for (int i=0;i<n;i++){
            dp[i][i] = true;
            count++;
        }
        for (int len=2;len<=n;len++){
            for (int i=0;i<n-len+1;i++){
                int j =i+len-1;
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }
                else{
                    if(len==2){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];

                    }
                }
                if(dp[i][j]){
                    count++;
                }
            }
            
        }
        return count;      
    }
}

