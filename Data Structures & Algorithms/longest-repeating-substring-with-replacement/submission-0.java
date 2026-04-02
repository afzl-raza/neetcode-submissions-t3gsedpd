class Solution {
    public int characterReplacement(String s, int k) {
        int left =0;
        int max_freq = 1;
        int n = s.length();
        int longest =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right=0;right<n;right++){
            char curr = s.charAt(right);
            map.put(curr,map.getOrDefault(curr,0)+1);
            int curr_freq = map.get(curr);
            
            if (max_freq<curr_freq){
                max_freq = curr_freq;
            }
            int size = right-left+1;
            if (size-max_freq<=k){
                if (size>longest)
                    longest = size;
                }
            else{
                char l = s.charAt(left);
                map.put(l,map.get(l)-1);
                left++;
            }    
        }
        return longest;
        
    }
}
