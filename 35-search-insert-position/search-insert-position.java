class Solution {
    public int searchInsert(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while(leftIndex<=rightIndex) {
            int midIndex=leftIndex+(rightIndex-leftIndex)/2;

            if(nums[midIndex]==target) return midIndex;
            if(target<nums[midIndex]) {
                rightIndex=midIndex-1;
            } else {
                leftIndex=midIndex+1;
            }
        }
        return leftIndex+(rightIndex-leftIndex)/2;
    }
}