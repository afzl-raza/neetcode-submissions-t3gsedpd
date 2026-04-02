class Solution {
    public boolean is_anagram(String s1,String s2){
        int[] s1_map = new int[26];
        for (char c:s1.toCharArray()){
            s1_map[c-'a']+=1;
        }
        int [] s2_map = new int[26];
        for (char c:s2.toCharArray()){
            s2_map[c-'a']+=1;
        }
        return (Arrays.equals(s1_map,s2_map));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans =new ArrayList<>();
        int n = strs.length;
        boolean[] flag = new boolean[n];
        for (int i=0;i<n;i++){
            if (flag[i]){
                continue;
            }
            List<String> temp = new ArrayList<>();
            flag[i] = true;
            temp.add(strs[i]);
            for (int j=i+1;j<n;j++){
                if (!flag[j]&& is_anagram(strs[i],strs[j])){
                    temp.add(strs[j]);
                    flag[j]=true;
                }   
            }
            ans.add(temp);
        }
        return ans;   
    }
}
