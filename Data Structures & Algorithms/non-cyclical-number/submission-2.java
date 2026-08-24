class Solution {
    int check(int n){
        int sum = 0;
        while(n>0){
            int rem = (n%10);
            sum+= rem*rem;
            n=n/10;
        }
        return sum;
        
    }
    public boolean isHappy(int n) {
        // boolean ans=false;
        Set<Integer> set = new HashSet<>();
        int num = n;
        while(!set.contains(num)){
            set.add(num);
            int ans = check(num);
            if(ans==1) return true;
            else{
                num = ans;
            }
        }
        return false; 
    }
}
