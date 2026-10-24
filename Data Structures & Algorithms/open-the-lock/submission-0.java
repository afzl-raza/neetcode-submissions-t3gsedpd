class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>();
        for(String deadend:deadends){
            deadendSet.add(deadend);
        }
        if(deadendSet.contains(target) || deadendSet.contains("0000")) return -1;
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.offer("0000");
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                String curr = q.poll();
                if(curr.equals(target)) return count;
                // visited.add(curr); why here this would not work???
                char[] currArr = curr.toCharArray();
                //Forward pass;
                for(int i=0;i<4;i++){
                    char org = currArr[i];
                    int newChar = (org=='9')?'0':(org+1);
                    currArr[i] = (char)newChar;
                    String newStr = new String(currArr);
                    currArr[i] = org;
                    if(visited.contains(newStr) || deadendSet.contains(newStr)) continue;
                    if(newStr.equals(target)) return count+1;
                    q.offer(newStr);
                    visited.add(newStr);
                }
                // Backward pass
                for(int i=0;i<4;i++){
                    char org = currArr[i];
                    int newChar = (org=='0')?'9':(org-1);
                    currArr[i] = (char)newChar;
                    String newStr = new String(currArr);
                    currArr[i] = org;
                    if(visited.contains(newStr) || deadendSet.contains(newStr)) continue;
                    // if(newStr.equals(target)) return count;
                    q.offer(newStr);
                    visited.add(newStr);
                }

            }
            count++;
        }
        return -1;    
    }
}