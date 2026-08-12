class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        int[][] cost = new int[n][m];
        int startCost = grid[0][0];
        
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
        }
        int[] nVal = new int[3];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0],b[0]));
        nVal[0] = startCost;
        nVal[1] = 0;
        nVal[2] = 0;
        minHeap.add(nVal);
        cost[0][0] = startCost;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int currentCost = curr[0];
            int row = curr[1];
            int col = curr[2];
            if (row == n - 1 && col == m - 1) {
                return currentCost;
            }
            for (int i=0;i<4;i++){
                int nr = row+dRow[i];
                int nc = col+dCol[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                int newCost = Math.max(currentCost, grid[nr][nc]);
                // if (nr == n - 1 && nc == n - 1) {
                //     return newCost;
                // }
                if (newCost < cost[nr][nc]) {
                    cost[nr][nc] = newCost;
                    minHeap.offer(new int[]{newCost, nr, nc});
                }

            }

        }
        return -1;
    }
}
