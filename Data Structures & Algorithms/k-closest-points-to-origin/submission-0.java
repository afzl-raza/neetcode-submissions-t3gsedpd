class Solution {
    int k;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->-Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]));
    public int[][] kClosest(int[][] points, int k) {
        this.k = k;
        for(int[] point:points) add(point);
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++) ans[i] = pq.poll();
        return ans;
    }
    public void add(int[] point){
        pq.offer(point);
        if(pq.size()>k) pq.poll();   
    }

}
