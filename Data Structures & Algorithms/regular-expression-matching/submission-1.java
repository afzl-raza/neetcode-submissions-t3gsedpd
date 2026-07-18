class Solution {
    public boolean Match(String s, String p, int i,int j, Boolean[][]dp){
        if(dp[i][j]!=null) return dp[i][j];
        // if(i<s.length() && j>p.length()) return false;
        // if(i>s.length() && j>p.length()) return true;
        
        if(j==p.length()){
            return dp[i][j] = (i == s.length());
        } 
        boolean firstMatch = (i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));
        // else if(s.charAt(i)!=p.charAt(j) && p.charAt(j)=='.') return Match(s,p,i+1,j+1);
        // else if (s.charAt(i)!=p.charAt(j) && p.charAt(j)=='*'){
        //     while (j-1>=0 && p.charAt(j-1)==s.charAt(i)){
        //         return Match(s,p,i-1,j);
        //     }
        boolean ans;
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            boolean skip = Match(s,p,i,j+2,dp);
            ans = dp[i][j]= skip || (firstMatch && Match(s,p,i+1,j,dp));
        }
        else{
            ans =(firstMatch && Match(s,p,i+1,j+1,dp));
        }
        return dp[i][j] = ans;
    }
    public boolean isMatch(String s, String p) {
        Boolean [][] dp  = new Boolean[s.length()+1][p.length()+1];
        return Match(s,p,0,0,dp);
    }
}
