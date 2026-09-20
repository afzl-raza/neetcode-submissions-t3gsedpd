class Solution {
    void bfs(int[][] grid, Queue<int[]> q){
        int m = grid.length;
        int n = grid[0].length;
        int[] r = new int[]{0,0,1,-1};
        int[] c = new int[]{1,-1,0,0};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0;d<4;d++){
                int newR = r[d]+curr[0];
                int newC = c[d]+curr[1];
                if(newR<0 || newR>=m || newC<0 || newC>=n || grid[newR][newC]!=Integer.MAX_VALUE ) continue;
                // if() continue;
                int newD = curr[2]+1;
                grid[newR][newC] = newD;
                q.offer(new int[]{newR,newC,newD});
            }
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        bfs(grid,q);
        
    }
}
