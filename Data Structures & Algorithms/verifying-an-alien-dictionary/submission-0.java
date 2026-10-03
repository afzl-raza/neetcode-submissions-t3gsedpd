class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,List<Character>> orderMap = new HashMap<>();
        int n = order.length();
        for(int i=0;i<n;i++){
            List<Character> val = orderMap.getOrDefault(order.charAt(i),new ArrayList<>());
            for(int j=i+1;j<n;j++){
                val.add(order.charAt(j));
            }
            orderMap.put(order.charAt(i),val);
        }
        Map<Character, Character> map = new HashMap<>();
        int m = words.length;
        for(int i=1;i<m;i++){
            char[] word1 = words[i-1].toCharArray();
            char[] word2 = words[i].toCharArray();
            int min = Math.min(word1.length,word2.length);
            boolean different = false;
            for(int j=0;j<min;j++){
                if(word1[j]!=word2[j]){
                    map.put(word1[j],word2[j]);
                    different= true;
                    break;
                }
            }
            if(!different && word1.length>word2.length) return false;
        }
        for(char k: map.keySet()){
            if(orderMap.get(k)==null || orderMap.get(k).isEmpty()) return false;
            boolean found = false;
            for(char v:orderMap.get(k)){
                if(map.get(k)==v){
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }
        return true;    
    }
}