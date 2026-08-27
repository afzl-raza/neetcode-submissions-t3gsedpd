class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[m+n];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int n1 = num1.charAt(i)-'0';
                int n2 = num2.charAt(j)-'0';
                int product = n1*n2;
                result[i+j+1]+= product;
                int val = result[i+j+1]%10;
                int carry = result[i+j+1]/10;
                result[i+j+1] =val;
                result[i+j]+=carry;
                
            }
        }
        int start=0;
        while(result[start]==0) start++;
        char[] ans = new char[result.length-start];
        for(int i=start;i<result.length;i++){
            ans[i-start] = (char)(result[i]+'0');

        }
        return new String(ans);
        

    }
}
