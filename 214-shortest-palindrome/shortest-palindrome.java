// Brute force approach
// class Solution {
//     public String shortestPalindrome(String s) {
//         String r = new StringBuilder(s).reverse().toString();
//         int len = s.length();
        
//         for (int i = 0; i <= len; i++) {
//             if (s.substring(0, len - i).equals(r.substring(i))) {
//                 return r.substring(0, i) + s;
//             }
//         }
//         return "";
//     }
// }

// KMP Algorithm
class Solution {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String ts = s + "#" + r;
        int n = ts.length();
        int[] pi = new int[n];

        // Compute prefix function (KMP partial match table)
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && ts.charAt(i) != ts.charAt(j)) {
                j = pi[j - 1];
            }
            if (ts.charAt(i) == ts.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        return r.substring(0, r.length() - pi[n - 1]) + s;
    }
}
