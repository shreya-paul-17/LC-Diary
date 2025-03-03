// class Solution {
//     public String largestOddNumber(String num) {
//         int n = num.length(), idx = -1;
//             for (int i = n-1; i>=0; i--) {
//                 if (num.charAt(i) % 2 != 0) {
//                     idx = i;
//                     break;
//                 }
//             }
//             if (idx == -1) return "";
//             return num.substring(0, idx+1);
//     }
// }

class Solution {
    public String largestOddNumber(String num) {
        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}