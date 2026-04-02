class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(keys, (a, b) -> map.get(b) - map.get(a)); // descending frequency

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys[i];
        }
        return result;

        
    }
}
