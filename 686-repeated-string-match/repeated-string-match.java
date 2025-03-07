class Solution {
    
    // Rabin-Karp Algorithm to check if pattern s2 exists in text s1
    public int Rabin_Karp(String s1, String s2) {
        long m = s1.length();
        long n = s2.length();
        
        long p = 31;
        long pow = 1;
        long mod = 1000000007;
        long targetHashVal = 0;
        
        // Compute hash value of pattern (s2)
        for (int i = 0; i < n; i++) {
            targetHashVal = (targetHashVal + (s2.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (pow * p) % mod;
        }
        
        // Prefix hash array
        long[] pha = new long[(int) m];
        long[] pa = new long[(int) m];
        
        pha[0] = s1.charAt(0) - 'a' + 1;
        pa[0] = 1;
        pow = p;
        
        for (int i = 1; i < m; i++) {
            pha[i] = (pha[i - 1] + (s1.charAt(i) - 'a' + 1) * pow) % mod;
            pa[i] = pow;
            pow = (pow * p) % mod;
        }
        
        // Sliding window approach
        int sp = 0, ep = (int) n - 1;
        
        while (ep < m) {
            long win = pha[ep];
            if (sp > 0) {
                win = (win - pha[sp - 1] + mod) % mod;
            }
            
            if (win == (targetHashVal * pa[sp]) % mod) {
                return 1;
            }
            sp++;
            ep++;
        }
        return 0;
    }
    
    public int repeatedStringMatch(String A, String B) {
        // Edge case: If A is already equal to B
        if (A.equals(B)) return 1;
        
        int count = 1;
        StringBuilder source = new StringBuilder(A);
        
        // Repeat A until its length is at least B's length
        while (source.length() < B.length()) {
            source.append(A);
            count++;
        }
        
        // Check if B is now present in the repeated A
        if (source.toString().equals(B)) return count;
        if (Rabin_Karp(source.toString(), B) == 1) return count;
        if (Rabin_Karp(source.append(A).toString(), B) == 1) return count + 1;
        
        return -1;
    }
}