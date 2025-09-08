class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i<n; i++) {
            if(check(i) && check(n-i))
                return new int[]{i, n-i};
        }
        return new int[]{-1,-1};
    }

    public boolean check(int num) {
        while(num>0) {
            if(num%10 == 0) {
                return false;
            }
            num = num/10;
        }
        return true;
    }
}