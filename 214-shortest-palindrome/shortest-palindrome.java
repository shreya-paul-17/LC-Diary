// Brute force approach
class Solution {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int len = s.length();
        
        for (int i = 0; i <= len; i++) {
            if (s.substring(0, len - i).equals(r.substring(i))) {
                return r.substring(0, i) + s;
            }
        }
        return "";
    }
}
