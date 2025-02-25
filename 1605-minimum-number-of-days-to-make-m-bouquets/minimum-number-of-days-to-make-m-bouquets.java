class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long) m * k) return -1;

        // Find mini and maxi using a single loop
        int mini = bloomDay[0], maxi = bloomDay[0];
        for (int i = 1; i < n; i++) {
            if (bloomDay[i] < mini) mini = bloomDay[i];
            if (bloomDay[i] > maxi) maxi = bloomDay[i];
        }

        int low = mini, high = maxi, ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean possible(int[] bloomDay, int day, int m, int k) {
        int cnt = 0, noB = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) { // Enclosed block
                cnt++;
                if (cnt == k) {
                    noB++;  // One bouquet formed
                    cnt = 0;
                    if (noB >= m) return true; // Early exit
                }
            } else {
                cnt = 0; // Reset if bloomDay[i] > day
            }
        }
        return noB >= m;
    }
}
