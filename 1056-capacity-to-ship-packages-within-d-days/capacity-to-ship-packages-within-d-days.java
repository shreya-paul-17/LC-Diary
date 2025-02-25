import java.util.*;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        long sum = 0, maxi = 0;
        for (int wt : weights) {
            sum += (long) wt;
            maxi = Math.max(maxi, (long) wt);
        }

        int low = (int) maxi, high = (int) sum, ans = (int) sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValid(int[] weights, int cap, int days) {
        int day = 1, load = 0;
        for (int wt : weights) {
            if (load + wt > cap) {
                day++;
                load = 0;
            }
            load += wt;
            if (day > days) return false;
        }
        return true;
    }
}
