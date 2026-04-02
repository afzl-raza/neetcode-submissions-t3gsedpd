class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // Buckets: index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : freq.keySet()) {
            int f = freq.get(num);
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(num);
        }

        // Collect top k
        int[] ans = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    ans[idx++] = num;
                    if (idx == k) break;
                }
            }
        }

        return ans;
    }
}

