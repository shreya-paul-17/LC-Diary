class Solution {
    public boolean isPalindrome(int x) {
     int res=0;
     int n=x;
     if(x<0)
     return false;
     for(int i=x; i>0; i/=10){
        res=res*10+(i%10);
     }
     return (n==res)?true:false;
    }
}