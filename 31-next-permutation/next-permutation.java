class Solution {
    public void nextPermutation(int[] nums) {
        int ind1=-1, ind2=-1;
        // Finding break point
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                ind1=i;
                break;
            }
        }
        // If no breaking point exists
        if(ind1==-1) {
            reverse(nums, 0);
        } else {
            // Find next greater element and swap it with ind2
            for(int i=nums.length-1; i>=0; i--) {
                if(nums[i]>nums[ind1]) {
                    ind2=i;
                    break;
                }
            }

            swap(nums, ind1, ind2);
            // Reverse the rest right half
            reverse(nums, ind1+1);
        }
    }
    void swap(int nums[], int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int nums[], int start) {
        int i=start;
        int j=nums.length-1;
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}