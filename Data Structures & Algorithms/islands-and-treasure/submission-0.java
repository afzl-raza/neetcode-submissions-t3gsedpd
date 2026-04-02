class Solution {
    public void run_bfs(Deque<int[]> q,int[][]grid){
        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0;i<size;i++){
                int[] arr = q.poll();
                int r= arr[0];
                int c = arr[1];
                if (r-1>=0  && grid[r-1][c]==Integer.MAX_VALUE){
                    grid[r-1][c] = grid[r][c]+1;
                    q.offer(new int[]{r-1,c});
                }
                if ((r+1<grid.length) && grid[r+1][c]==Integer.MAX_VALUE){
                    grid[r+1][c] = grid[r][c]+1;
                    q.offer(new int[]{r+1,c});
                }
                if (c-1>=0 && grid[r][c-1]==Integer.MAX_VALUE){
                    grid[r][c-1] = grid[r][c]+1;
                    q.offer(new int[]{r,c-1});

                }
                if (c+1<grid[0].length && grid[r][c+1]==Integer.MAX_VALUE){
                    grid[r][c+1] =grid[r][c]+1 ;
                    q.offer(new int[]{r,c+1});
                }
            }
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        run_bfs(queue,grid);   
    }
}
