class Solution {
    public boolean feasible(int[] piles, int speed, int maxHour){
        int count = 0;
        for(int bananas:piles){
            if(bananas%speed==0) count+= bananas/speed;
            else{
                count+= bananas/speed+1;
            }
        }
        return (count<=maxHour)? true:false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i=1;i<piles.length;i++){
            max = Math.max(piles[i],max);
        }
        int l = 1;
        int r = max;
        while(l<=r){
            int mid = (l+(r-l)/2);
            if(feasible(piles,mid,h)){
                r = mid-1; // speed should be decreased;
            }
            else{
                l = mid+1; //spedd has to be increased;
            }
        }
        return l;
        
    }
}
