class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Creating arrays to store the idx of characters in both strings
        int indexS[] = new int[200]; // Stores the index of characters in String s
        int indexT[] = new int[200]; // Stores the index of characters in String t

        // Getting the length of both the strings
        int len = s.length();

        // If the length of 2 different strings is not same then they can't be isomorphic
        if (len != t.length()) {
            return false;
        }

        // Iterate through each characteer in the string
        for (int i=0; i<len; i++) {
            // Checking if the index of the current character in String s is different from the index of the corresponding character in String t
            if (indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false; 
            }

            // Updating the indices of characters in both strings
            indexS[s.charAt(i)] = i+1; // Updating the index of the current character
            indexT[t.charAt(i)] = i+1; // Updating the index of the current character
        }

        // If the loop completes without returning false, strings are isomorphic
        return true;
    }
}