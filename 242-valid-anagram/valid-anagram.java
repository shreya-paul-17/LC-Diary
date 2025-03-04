class Solution {
    public boolean isAnagram(String s, String t) {
       Map<Character, Integer> count = new HashMap<>();

       // Counting the frequency of characters in String s
       for (char x : s.toCharArray()) {
        count.put(x, count.getOrDefault(x, 0) + 1);
       } 

       // Decrement the frequency of characters in String t
       for (char x : t.toCharArray()) {
        count.put(x, count.getOrDefault(x, 0) - 1);
       }

       // Check if any character has non-zero frequency
       for (int val : count.values()) {
        if (val != 0) {
            return false;
        }
       }

       return true;
    }
}