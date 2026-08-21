class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            map.put(curr,i);
        }
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int farthest = 0;
        for(int i=0;i<s.length();i++){
            farthest = Math.max(farthest,map.get(s.charAt(i)));
            count++;
            if(i==farthest){
                ans.add(count);
                count = 0;
            }
            
        }
        return ans;    
    }
}
