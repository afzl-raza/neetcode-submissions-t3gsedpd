class Solution {
    boolean dfs(int node, Map<Integer,List<Integer>> graph, boolean[] visited,boolean[] pathvisited){
        visited[node] = true;
        pathvisited[node] = true;
        if(graph.get(node)!=null && !graph.get(node).isEmpty()){
            for(int neigh: graph.get(node)){
                if(!visited[neigh]){
                    if(dfs(neigh,graph, visited, pathvisited)) return true;
                }
                else if(pathvisited[neigh]) return true;
            }
            
        }
        pathvisited[node] = false;
        return false;
        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.putIfAbsent(i,new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            List<Integer> l = graph.get(edge[1]);  //prerequsite -> course
            l.add(edge[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathvisited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(i,graph, visited,pathvisited)){
                return false;
            }
        }
        return true;
        
    }
}
