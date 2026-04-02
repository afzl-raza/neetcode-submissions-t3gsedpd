class Solution {
    public String minWindow(String s, String t) {
        if (t.length()>s.length()){
            return "";
        }
        int count =0;
        int[] t_map = new int[128];
        int[] s_map = new int[128];
        for (char c:t.toCharArray()){
            t_map[c]+=1;
            count++;
        }
        int min_size =Integer.MAX_VALUE;
        String ans_str ="";
        int left=0;
        for (int right=0;right<s.length();right++){
            char c = s.charAt(right);
            s_map[c]+=1;
            if (t_map[c]>0 && s_map[c]<=t_map[c]){
                count--;
            }
            if (count==0){
                int curr_size = right-left+1;
                if (curr_size<min_size){
                    ans_str = s.substring(left,right+1);
                    min_size = curr_size;
                }
                while(count==0){
                    int size= right-left+1;
                    if (size<min_size){
                        ans_str = s.substring(left,right+1);
                        min_size = size;
                    }
                    char l = s.charAt(left);
                    s_map[l]-=1;
                    left++;
                    if (t_map[l]>0 && t_map[l]>s_map[l]){
                        count++;
                    }    
                }
            }
        }
        return ans_str;    
    }
}
