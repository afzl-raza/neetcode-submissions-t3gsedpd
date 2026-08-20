class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // The naive or bturte force approach is this 
        // For every gas station, calculate the cost of moving around the all indeces 
        // and pick up the minimum cost and then return it.
        // but this approach will take O(n**2)time;
        // How to optimise this solution???
        int n = gas.length;
        int totalGas =0;
        int totalCost =0;
        for(int i=0;i<n;i++){
            totalGas+= gas[i];
            totalCost+=cost[i];
        }
        if(totalGas<totalCost) return -1;
        
        int result =0;
        int total = 0;

        for(int i=0;i<n;i++){
            total+=(gas[i]-cost[i]);
            if(total<0){
                total = 0;
                result = i+1;
            }
        }
        if(result ==n) return 0;
        return result;
        
        
    }
}
