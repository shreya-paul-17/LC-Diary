import java.util.*;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int low = 1, high = maxElement, ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumOfDiv(nums, mid, threshold) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int sumOfDiv(int[] nums, int div, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + div - 1) / div;
            if (sum > threshold) break;
        }
        return sum;
    }
}