class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> validTriplet = new ArrayList<>();
        for(int[] trip:triplets){
            if(trip[0]>target[0] || trip[1]>target[1] || trip[2]>target[2]){
                continue;
            }
            validTriplet.add(trip);
        }
        boolean pos0=false;
        boolean pos1 = false;
        boolean pos2 = false;
        for(int[]t:validTriplet){
            if(t[0]==target[0]) pos0=true;
            if(t[1]==target[1]) pos1=true;
            if(t[2]==target[2]) pos2=true;
        }
        return (pos0 && pos1 && pos2);
        
    }
}
