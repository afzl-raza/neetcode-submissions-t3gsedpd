class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] char_arr = new int[128];
        int n = s.length();
        int max_wind = 0;
        int left =0;
        int right=0;
        while(right<n){
            char c = s.charAt(right);
            char_arr[c]++;
            while(char_arr[c]>1){
                char curr = s.charAt(left);
                char_arr[curr]--;
                left++;
            }
            int count = right-left+1;
            max_wind= Math.max(max_wind,count);
            right++;
        }
        return max_wind;
        
    }
}
