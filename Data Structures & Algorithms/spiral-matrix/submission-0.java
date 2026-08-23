class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        List<Integer> ans = new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int col=left;col<=right;col++){
                ans.add(matrix[top][col]);
            }
            top++;
            for(int row=top;row<=bottom;row++){
                ans.add(matrix[row][right]);
            }
            right--;
            if(top<=bottom && left <= right){
                for(int col=right;col>=left;col--){
                    ans.add(matrix[bottom][col]);
                }
                bottom-=1;
            }
            if(left<=right && top<=bottom){
                for(int row=bottom;row>=top;row--){
                    ans.add(matrix[row][left]);
                }
                left++;
            }
        }
        return ans;
        
    }
}
