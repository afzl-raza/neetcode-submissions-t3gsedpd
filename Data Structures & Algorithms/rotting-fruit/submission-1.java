class Solution {
    int[][] grid;
    int fresh =0;
    public int bfs_level(Queue<int []> q){
        int level=0;
        while(!q.isEmpty()){
            boolean spread = false;
            int size = q.size();
            for (int i=0;i<size;i++){
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];
                //check left 
                if (c-1>=0 && c-1<grid[0].length && grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    spread =true;
                    q.offer(new int[]{r,c-1});
                    fresh--;
                }
                //check right
                if (c+1>=0 && c+1<grid[0].length && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    spread =true;
                    q.offer(new int[]{r,c+1});
                    fresh--;
                }
                //check up
                if (r-1>=0 && r-1<grid.length && grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    spread = true;
                    q.offer(new int[]{r-1,c});
                    fresh--;
                }
                //check down
                if (r+1>=0 && r+1<grid.length && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    spread = true;
                    q.offer(new int[]{r+1,c});
                    fresh--;
                }
            }
            if (spread) level++;
        }
        return level;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new ArrayDeque<>();
        this.grid = grid;
        boolean flag = false;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if (grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int level = bfs_level(q);
        // for (int i=0;i<grid.length;i++){
        //     for (int j=0;j<grid[0].length;j++){
        //         if (grid[i][j]==1){
        //             flag=true;
        //         }
        //     }
        // }
        // return flag==true:-1?level;
        return fresh>0 ? -1 : level;   
    }
}
