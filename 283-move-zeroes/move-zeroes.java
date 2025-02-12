class Solution {
    public void moveZeroes(int[] nums) {
       int nonzero = 0; // Pointer to placce the next non-zero element

       for(int i=0; i<nums.length; i++) {
        if(nums[i] != 0) {
            // Swap the non-zero element with the element at non-zero
            int temp=nums[i];
            nums[i]=nums[nonzero];
            nums[nonzero] = temp;
            nonzero++; // Incrementing the non-zero pointer
        }
       } 
    }
}