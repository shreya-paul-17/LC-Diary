class Solution {
    public int longestConsecutive(int[] nums) {
        int res=0;
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        for(int n: nums) {
            if(!map.containsKey(n)) {
                int left = (map.containsKey(n-1))?map.get(n-1):0;
                int right = (map.containsKey(n+1))?map.get(n+1):0;
                // sum- length of the sequence n
                int sum=left+right+1;
                map.put(n, sum);

                // Keeping track of the max length
                res=Math.max(res, sum);

                // Extend the length to the boundary(s) of the sequence
                // Will do nothing if n has no neighbours 
                map.put(n-left, sum);
                map.put(n+right, sum);
            } else {
                // Duplicates
                continue;
            }
        }
        return res;
    }
}