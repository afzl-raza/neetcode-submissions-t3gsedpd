class Solution {
    List<Integer> bfs(Queue<Integer> q, Map<Integer,List<Integer>> graph,int[] indegree){
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            if(graph.get(curr)!=null && !graph.get(curr).isEmpty()){
                for(int neigh:graph.get(curr)){
                    indegree[neigh]--;
                    if(indegree[neigh]==0) q.offer(neigh);

                }
            }
        }
        return ans;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int node=0;node<numCourses;node++){
            graph.computeIfAbsent(node,k->new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            graph.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++; //  directed graph from preq->courses
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }
        List<Integer> ans = bfs(q,graph, indegree);
        if(ans.size()!=numCourses) return new int[0];
        else{
            return ans.stream().mapToInt(i->i).toArray();
        }



        
    }
}
