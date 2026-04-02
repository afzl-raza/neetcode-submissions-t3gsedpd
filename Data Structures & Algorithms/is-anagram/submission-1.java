class Solution {
    public boolean isAnagram(String s, String t) {
       int[] s_map = new int[26];
       int[] t_map = new int[26];
       for (char c:s.toCharArray()){
        s_map[c-'a']+=1;
       }
       for (char c:t.toCharArray()){
        t_map[c-'a']+=1;
       }
       return Arrays.equals(s_map,t_map);

    }
}
