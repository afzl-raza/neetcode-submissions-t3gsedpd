class Solution {
    int digitSquare(int n){
        int sum=0;
        for(;n>0;n=n/10){
            int rem = n%10;
            sum+= rem*rem;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true){
            n = digitSquare(n);
            if(n==1) return true;
            if(set.contains(n)) return false;
            set.add(n);

        }
        
    }
}
