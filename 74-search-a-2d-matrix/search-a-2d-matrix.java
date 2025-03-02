class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        return binarySearch(matrix ,target, 0, (m*n)-1, m);
    }

    public static boolean binarySearch(int arr[][], int target, int low, int high, int m){
        if(high>=low){
            int mid = (high+low)/2;
            int row = mid/m;
            int col = mid%m;
            if(arr[row][col]==target) return true;
            else if(arr[row][col]>target){
                return binarySearch(arr, target, low, mid-1, m);
            }
            else{
                return binarySearch(arr, target, mid+1, high, m);
            }
        }
        return false;
    }
}