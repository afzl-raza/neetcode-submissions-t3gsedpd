class Solution {
    public boolean dfs(int i,Map<Integer,List<Integer>> adj,boolean[] visited,boolean[] pathVisited){
        visited[i] = true;
        pathVisited[i] = true;
        if (adj.containsKey(i)){
            for (int neigh:adj.get(i)){
            if(!visited[neigh]){
                if(dfs(neigh,adj,visited,pathVisited)) return true;
            }
            else if (pathVisited[neigh]) return true;
        }
        }
        pathVisited[i]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        // Map<Integer,Integer> adj = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i=0;i<n;i++){
            int[] edge = prerequisites[i];
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            //adj.get(edge[0].put(edge[0],edge[1]));
            //adj.get(edge[1].put(edge[1],edge[0]));
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for (int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathVisited)) return false;
            }
        }
        return true;    
    }
}
