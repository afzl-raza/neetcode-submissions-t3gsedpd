class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1_map = new int[26];
        int[] s2_map = new int[26];
        for (char c:s1.toCharArray()){
            s1_map[c-'a']+=1;
        }
        int k = s1.length();
        int n = s2.length();
        if (k>n){
            return false;
        }
        for (int i=0;i<k;i++){
            char c = s2.charAt(i);
            s2_map[c-'a']+=1;
        }
        if (Arrays.equals(s1_map,s2_map)){
            return true;
        }
        for (int i=k;i<n;i++){
            char rem = s2.charAt(i-k);
            char ad = s2.charAt(i);
            s2_map[rem-'a']-=1;
            s2_map[ad-'a']+=1;
            if (Arrays.equals(s1_map,s2_map)){
                return true;
            }
        }
        return false;
        
    }
}
