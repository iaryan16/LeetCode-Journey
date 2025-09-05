class Solution {
    public double myPow(double x, int n) {
        
        if(n < 0) {
            x = 1/x;
        }     

        long exp = (Math.abs((long)n));

        double res = 1;

        while(exp != 0) {
            if((exp & 1) == 1) {
                res *= x;
            }
            x *= x;
            exp = exp >> 1;
        }   
        return res;
    
    }
}