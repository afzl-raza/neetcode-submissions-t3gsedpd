class Solution {
    void bfs(int[][] grid, Queue<int[]> q,boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        while(!q.isEmpty()){
            int[] r = new int[]{1,-1,0,0};
            int[] c = new int[]{0,0,1,-1};
            int[] curr = q.poll();
            for(int d=0;d<4;d++){
                int newR = curr[0]+r[d];
                int newC = curr[1]+c[d];
                if(newR>=0 && newR<m && newC>=0 && newC<n && !visited[newR][newC]){
                    if(grid[newR][newC]!=-1){
                        int newD = curr[2]+1;
                        grid[newR][newC] = newD;
                        visited[newR][newC] = true;
                        q.offer(new int[]{newR,newC,newD});
                    }
                    
                }
            }

        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        bfs(grid,q,visited);
        
    }
}
