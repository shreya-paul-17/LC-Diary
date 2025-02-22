class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int left=0, right=n-1;
        int ans=Integer.MAX_VALUE;

        while(left<=right) {
            int mid=(left+right)/2;
            if(arr[left]<=arr[right]) {
                ans= Math.min(ans, arr[left]);
                break;
            }

            if(arr[left]<=arr[mid]) {
                ans=Math.min(ans, arr[left]);
                left=mid+1;
            } else {
                ans=Math.min(ans, arr[mid]);
                right=mid-1;
            }
        }
        return ans;
    }
}