class Solution {
    int[] parent;
    public int find_set(int v){
        if(parent[v]==v) return v;
        return parent[v]=find_set(parent[v]);
    }

    public boolean union_set(int u, int v){
        u = find_set(u);
        v = find_set(v);
        if(u==v){
            return true;
        }
        parent[u] = v;
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            if(union_set(u,v)) return new int[]{u,v};
        }
        return new int[0];
        
    }
}
