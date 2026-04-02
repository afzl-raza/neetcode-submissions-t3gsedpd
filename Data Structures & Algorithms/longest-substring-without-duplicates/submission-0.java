class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int max_wind = 0;
        for (int i=0;i<n;i++){
            HashSet<Character> set = new HashSet<>();
            int current = 0;
            for (int j=i;j<n;j++){
                char c = s.charAt(j);
                if (set.contains(c)){
                    break;
                }
                set.add(c);
                current = j-i+1;
                max_wind = Math.max(current,max_wind);
            }
        }
        return max_wind;
        
    }
}
