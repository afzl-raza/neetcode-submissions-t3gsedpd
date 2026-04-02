class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String curr:strs){
            int[] c_map = new int[26];
            for (char c:curr.toCharArray()){
                c_map[c-'a']+=1;    
            }
            String key = Arrays.toString(c_map);
            if (!map.containsKey(key)){
                List<String> temp = new ArrayList<>();
                temp.add(curr);
                map.put(key,temp);
            }
            else{
                List<String> val = map.get(key);
                val.add(curr);
            }
        }
        return new ArrayList<>(map.values());
        
    }
}
