class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x !=0)
        {
            int tmp = x%10;
            res = res*10+tmp;
            x = (x)/10;
            
            if(res%10!=tmp) 
            {
                return 0;
            }
        }
        
        return res;
    }
}