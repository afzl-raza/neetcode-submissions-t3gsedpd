class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n-2;i++){
            if ( i>0 && nums[i]==nums[i-1]){
                continue;
            }
            if (nums[i]>0){
                break;
            }
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==0){
                    List<Integer> myList = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    ans.add(myList);
                    left++;
                    right--;
                    // skip duplicate left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                // skip duplicate right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if (sum>0){
                    right--;
                }
                else if (sum<0){
                    left++;
                }
                }
            }
            return ans; 
        }   
    }

