class Solution {
    public int find(int x, int[] parent){
        if(parent[x]==x){
            return x;
        }
        // x = parent[x];
        int root = find(parent[x], parent);
        parent[x] = root;
        return root;
    }
    public boolean  union(int u, int v,int[] parent){
        int root1 = find(u,parent);
        int root2 = find(v,parent);
        if(root1!=root2){
            parent[root1] = root2;
            return true;
        }
        return false;    
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            if(!union(edge[0], edge[1],parent)){
                return edge;
            }
        }
        return new int[2];   
    }
}
