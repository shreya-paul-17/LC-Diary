// import java.util.Arrays;
// import java.util.HashMap;

// class Solution {
//     public int maxFrequency(int[] nums, int k) {
//         int n = nums.length;
//         int maxFreq = 1;
        
//         // Sort the array
//         Arrays.sort(nums);
        
//         // HashMap to store the frequency of numbers
//         HashMap<Integer, Integer> freqMap = new HashMap<>();
        
//         for (int num : nums) {
//             freqMap.put(num, 1);
//         }
        
//         int remainingK;
//         for (int i = 1; i < n; i++) {
//             remainingK = k;
//             int j = i - 1;
            
//             if (nums[i] == nums[j]) {
//                 freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
//                 maxFreq = Math.max(maxFreq, freqMap.get(nums[i]));
//             } else {
//                 while (remainingK > 0 && j >= 0) {
//                     remainingK -= (nums[i] - nums[j]);
//                     if (remainingK >= 0) {
//                         freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
//                     }
//                     j--;
//                     maxFreq = Math.max(maxFreq, freqMap.get(nums[i]));
//                 }
//             }
//         }
        
//         return maxFreq;
//     }

//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int[] nums = {3, 9, 6, 5, 2};
//         int k = 4;
//         System.out.println(sol.maxFrequency(nums, k));  // Output the maximum frequency
//     }
// }


class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        int left=0;
        int sum_window = nums[0];
        for(int right=1;right<nums.length;right++){
            sum_window+=nums[right];
            int operations_needed = (nums[right]*(right-left+1))-sum_window;
            if(operations_needed<0) operations_needed=Integer.MAX_VALUE;
            if(operations_needed>k){
                sum_window-=nums[left++];
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}