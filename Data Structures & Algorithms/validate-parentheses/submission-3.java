class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n%2!=0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Deque<Character> deq = new ArrayDeque<>();    
        for (int i=0;i<n;i++){
            char c = s.charAt(i);
            if (c=='('||c=='[' || c=='{'){
                deq.offerLast(c);
            }
            else{
                if (deq.isEmpty()){
                    return false;
                }
                char top = deq.pollLast();
                if (map.get(top)!=c){
                    return false;    
                }
                
            }
        }
        return (deq.isEmpty());    
    }
}
