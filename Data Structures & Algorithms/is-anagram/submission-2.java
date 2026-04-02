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
       for (int i=0;i<s_map.length;i++){
        if (s_map[i]!=t_map[i]){
            return false;
        }
       }
       return true;

    }
}
