class Solution {
    int bfs(int[][] grid, Queue<int[]> q){
        int m =grid.length;
        int n = grid[0].length;
        int[] r = new int[]{0,0,-1,1};
        int[] c = new int[]{1,-1,0,0};
        int time = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0;d<4;d++){
                int newR = curr[0]+r[d];
                int newC = curr[1]+c[d];
                if(newR<0 || newR>=m || newC<0 || newC>=n || grid[newR][newC]!=1) continue;
                grid[newR][newC] = 2;
                int newTime = curr[2]+1;
                time = Math.max(newTime, time);
                q.offer(new int[]{newR,newC,newTime});
                
            }
        }
        return time;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int freshOrange =0; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    // bfs(grid,new int[]{i,j,0});
                    q.offer(new int[] {i,j,0});
                }
                else if(grid[i][j]==1){
                    freshOrange++;
                }
            }
        }
        if(freshOrange==0) return 0;
        int ans = bfs(grid,q);
        boolean rotten = true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rotten = false;
                    return -1;
                }
                
            }
        }
        return ans;
        
    }
}
