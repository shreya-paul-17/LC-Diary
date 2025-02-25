class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007; // Large prime no. to prevent overflow for modulo operation
        long sum=0; // Cumulative sum tracker
        int odd=0, even=0; // Counters for odd and even prefix Sum
        long ans=0; // Stores the total no. of subarrays with an odd sum

        // Iterate through each element in the array
        for(int num:arr) {
            sum+=num; // Add current element to cumulative sum

            // If odd
            if(sum%2==1) {
                odd++; // Increment odd counter
                ans+=even+1; // Any previous even prefix sum+current subarray - odd     subarray
            } else {
                even++;
                ans+=odd; // Any previous odd prefix sum can form a new subarray
            }
        }
        return (int)(ans%mod); // Returning ans within modulo constraints
    }
}