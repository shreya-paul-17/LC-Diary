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

// KMP (Knuth-Morris-Pratt) Algorithm
// class Solution {
//     public String shortestPalindrome(String s) {
//         String r = new StringBuilder(s).reverse().toString();
//         String ts = s + "#" + r;
//         int n = ts.length();
//         int[] pi = new int[n];

//         // Compute prefix function (KMP partial match table)
//         for (int i = 1; i < n; i++) {
//             int j = pi[i - 1];
//             while (j > 0 && ts.charAt(i) != ts.charAt(j)) {
//                 j = pi[j - 1];
//             }
//             if (ts.charAt(i) == ts.charAt(j)) {
//                 j++;
//             }
//             pi[i] = j;
//         }

//         return r.substring(0, r.length() - pi[n - 1]) + s;
//     }
// }

// Rabin-Karp (Rolling Hash)
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int P = 31, MOD = 1000000007;
        long POW = 1, h1 = 0, h2 = 0;
        int maxPalindromicPrefixLength = 0;

        for (int i = 0; i < n; i++) {
            int charInt = s.charAt(i) - 'a' + 1;
            h1 = (h1 * P + charInt) % MOD;
            h2 = (charInt * POW + h2) % MOD;
            if (h1 == h2) {
                maxPalindromicPrefixLength = i + 1;
            }
            POW = (POW * P) % MOD;
        }

        return new StringBuilder(s.substring(maxPalindromicPrefixLength)).reverse().toString() + s;
    }
}
