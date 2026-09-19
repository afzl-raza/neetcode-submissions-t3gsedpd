class Solution {
    int area(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        grid[i][j] = 1;
        q.offer(new int[]{i,j});
        int count = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int[] r = new int[]{-1,0,1,0};
            int[] c = new int[]{0,1,0,-1};
            for(int d=0;d<4;d++){
                int newR = r[d]+curr[0];
                int newC = c[d]+curr[1];
                if(newR<0 || newR>=m || newC<0 || newC>=n || grid[newR][newC]==0) continue;
                grid[newR][newC] = 0;
                count++;
                q.offer(new int[]{newR,newC});    
            }
            
        }
        return (count==0)?1:count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int curr = area(grid,i,j);
                    max = Math.max(max,curr);
                }
            }
        }
        return (max==Integer.MIN_VALUE)?0:max;
        
        
    }
}
