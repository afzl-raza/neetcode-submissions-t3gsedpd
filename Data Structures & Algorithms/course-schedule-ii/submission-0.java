class Solution {
    public void kahns(Map<Integer,List<Integer>> graph,int numCourses,int[] indegree,Deque<Integer> queue,List<Integer> ans){
        while(!queue.isEmpty()){
            int node = queue.pop();
            ans.add(node);
            if(graph.containsKey(node)){
                for(int neigh:graph.get(node)){
                // graph.get(neigh).remove(node);
                // graph.get(node).remove(neigh);
                    indegree[neigh]--;
                    if(indegree[neigh]==0){
                        queue.add(neigh);
                    }
                }
            }
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<n;i++){
            int[] edge = prerequisites[i];
            graph.computeIfAbsent(edge[1],k-> new ArrayList<>()).add(edge[0]);
            indegree[edge[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        kahns(graph,numCourses,indegree,queue,ans);
        // Convert using Stream API
        int[] primitiveArray = ans.stream()
                                   .mapToInt(Integer::intValue)
                                   .toArray();
        if(ans.size()==numCourses) return primitiveArray;
        else{
            return new int[0];}   
    }
}
