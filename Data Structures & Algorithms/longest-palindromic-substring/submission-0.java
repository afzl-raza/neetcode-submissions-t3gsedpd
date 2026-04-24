class Solution {
    public boolean checkPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.subSequence(i,j+1).toString();
                if(checkPalindrome(sub) && sub.length() > ans.length()){
    ans = sub;
}
            }
        }
        return ans;
        
    }
}
