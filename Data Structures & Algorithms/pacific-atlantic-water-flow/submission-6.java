class Solution {
    int m;
    int n;
    boolean[][] atlantic;
    boolean[][] pacific;
    void bfs(int[][] grid,Queue<int[]>qP, Queue<int[]>qA){
        int[] rD = new int[]{0,0,1,-1};
        int[] cD = new int[]{1,-1,0,0};
        while(!qP.isEmpty()){
            int[] curr = qP.poll();
            int r = curr[0];
            int c = curr[1];
            for(int d=0;d<4;d++){
                int newR = r+rD[d];
                int newC = c+cD[d];
                if(newR<0 || newR>=m || newC<0 || newC>=n || pacific[newR][newC] || grid[newR][newC]<grid[r][c]) continue;
                pacific[newR][newC] = true;
                qP.offer(new int[]{newR,newC});    
            }
        }
        while(!qA.isEmpty()){
            int[] curr = qA.poll();
            int r = curr[0];
            int c = curr[1];
            for(int d=0;d<4;d++){
                int newR = r+rD[d];
                int newC = c+cD[d];
                if(newR<0 || newR>=m || newC<0 || newC>=n || atlantic[newR][newC] || grid[newR][newC]<grid[r][c]) continue;
                atlantic[newR][newC] = true;
                qA.offer(new int[]{newR,newC}); 
            }

        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.pacific = new boolean[m][n];
        this.atlantic = new boolean[m][n];
        Queue<int[]> pacificQ = new ArrayDeque<>();
        Queue<int[]> atlanticQ = new ArrayDeque<>();
        for(int i=0;i<m+n;i++){
            if(i<m){
                pacific[i][0]= true;
                pacificQ.offer(new int[]{i,0});
                atlantic[i][n-1] = true;
                atlanticQ.offer(new int[]{i,n-1});
            }
            
            if(i<n){
                pacific[0][i] = true;
                pacificQ.offer(new int[]{0,i});
                atlantic[m-1][i] = true;
                atlanticQ.offer(new int[]{m-1,i});
            }
        }
        bfs(heights,pacificQ,atlanticQ);
        List<List<Integer>> ans  = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(List.of(i,j));

                }
            }
        }
        return ans;
        
    }
}
