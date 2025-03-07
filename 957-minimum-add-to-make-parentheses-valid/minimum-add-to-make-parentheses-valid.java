class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left == 0) right++;
                else left--;
            }
        }
        return left+right;
    }
}