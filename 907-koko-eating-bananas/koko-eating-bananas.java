class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // binary seach
        int left = 1;
        int right = -1; // max pile 
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        while (left < right) {
            int speed = left + (right - left) / 2;
            boolean resultForSpeed = canFinish(piles, speed, h);
            if (!resultForSpeed) {
                left = speed + 1;
            }
            else {
                right = speed;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int totalTime = 0;
        for (int pile : piles) {
            int time = (pile + speed - 1) / speed;
            totalTime += time;
            if (totalTime > h) {
                return false;
            }
        }
        return true;
    }
}