class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if (n != m) return false;

       int[] s_map = new int[26];
       for (int i=0; i<n; i++) {
        s_map[s.charAt(i)-'a']++;
        s_map[t.charAt(i)-'a']--;
       }
       
       for(int bit: s_map) if (bit > 0) return false;
       return true;

    }
}
