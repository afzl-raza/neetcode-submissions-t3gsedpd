class Solution {
    int[] merge_two_sorted_arrays(int[] arr1,int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int[] res = new int[m+n];
        int i=0,j=0,k=0;
        while (i<m && j<n){
            if (arr1[i]<=arr2[j]){
                res[k] = arr1[i];
                i++;
                k++;
            }
            else{
                res[k] = arr2[j];
                j++;
                k++;
            }
        }
        if (i<m){
            while(i<m){
                res[k] = arr1[i];
                i++;
                k++;
            }
            
        }
        else{
            while(j<n){
                res[k] = arr2[j];
                j++;
                k++;
            }
        }
        return res;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = merge_two_sorted_arrays(nums1,nums2);
        int n = ans.length;
        if (n%2==0){
            return ((ans[n/2-1]+ans[n/2])/2.0);
        }
        else{
            return ans[n/2];
        }    
    
    }
}
