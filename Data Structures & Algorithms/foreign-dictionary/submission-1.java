class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        boolean[] present = new boolean[26];  
        Map<Character,Set<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        for(String word:words){
            for(char c:word.toCharArray()){
                present[c-'a'] = true;
                graph.putIfAbsent(c, new HashSet<Character>());
            }
        }
        for(int i=0;i<n-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            // here I am lagging the implementation. Thinking using two loop tow check the two wrods and get the unmatched character and build the graph else use one while loop to track the indices of the two words here..
            int minLength = Math.min(word1.length(),word2.length());
            boolean foundDifference = false;
            for(int j=0;j<minLength;j++){
                char u = word1.charAt(j);
                char v = word2.charAt(j);
                if(u!=v){
                    if(graph.get(u).add(v)){
                        indegree[v-'a']++;
                    } 
                    foundDifference = true;
                    break;              
                } 
            }
            if(!foundDifference && word1.length()>word2.length()) return "";
        }
        // Topological sort;
        StringBuilder sb = new StringBuilder();
        Deque<Character> q = new ArrayDeque<>();
        int totalCharacters = 0;
        for(int i=0;i<indegree.length;i++){
            if(present[i]){
                totalCharacters++;
            }
            if(indegree[i]==0 && present[i]) q.offer((char)('a'+i));
        }
        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            if(graph.get(curr)!=null){
                for(char c:graph.get(curr)){
                    indegree[c-'a']--;
                    if(indegree[c-'a']==0){
                        q.offer(c);
                    }
                }
            }
        }
        if(sb.length() != totalCharacters){ // done to ensure the total processed nodes in the graph. 
            return "";                                    // to check if the cycle is present or not;
        }
        return sb.toString();
    }
}
