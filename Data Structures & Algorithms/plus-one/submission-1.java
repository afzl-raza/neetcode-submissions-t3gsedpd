class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        if(digits[n-1]==9){
            int[] ans = new int[n+1];
            int carry = 1;
            for(int i=n-1;i>=0;i--){
                int sum = digits[i]+carry;
                ans[i+1] = sum%10;
                carry = sum/10;    
            }
            if(carry==1){
                ans[0] = 1;
                return ans;
            }
            else{
                return Arrays.copyOfRange(ans,1,n+1);
            }
        }
        else{
            digits[n-1]++;
            return digits;
        }
        
    }
}
