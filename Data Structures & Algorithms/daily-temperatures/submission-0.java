class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty()&& temp[i]>temp[stack.peek()]){
                int top = stack.pop();
                int wait = i-top;
                ans[top] = wait;
            }
            stack.push(i);
        }
        return ans;
        
    }
}
