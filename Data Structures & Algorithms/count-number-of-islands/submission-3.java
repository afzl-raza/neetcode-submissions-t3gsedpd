class Solution {
    void bfs(char[][] grid, int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        grid[i][j] = '0';
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int[] r = new int[]{-1,0,1,0};
            int[] c = new int[]{0,1,0,-1};
            for(int d=0;d<4;d++){
                int newR= curr[0]+r[d];
                int newC = curr[1]+c[d];
                if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]=='1'){
                    grid[newR][newC] = '0';
                    q.offer(new int[]{newR,newC});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count= 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
        
    }
}
