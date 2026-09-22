class Solution {
    boolean dfs(int src, int target, Map<Integer,List<Integer>> graph, boolean[] visited){
        visited[src] = true;
        if(graph.get(src)!=null && !graph.get(src).isEmpty())
        for(int neigh: graph.get(src)){
            if(!visited[neigh]){
                if(neigh==target) return true;
                if(dfs(neigh, target, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            boolean[] visited = new boolean[edges.length+1];
            if(dfs(u,v,graph,visited)) return new int[]{u,v};
            graph.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
        }
        return new int[0];
        // int v = ans.get(0)[1];
        // return new int[]{u,v};

        
    }
}
