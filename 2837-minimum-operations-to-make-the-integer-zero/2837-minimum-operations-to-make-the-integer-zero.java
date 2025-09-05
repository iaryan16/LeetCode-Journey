class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long i = 0; i <= 60; ++i) {
            long val = num1 - i * num2;
            if(val < 0) return -1;
            if (Long.bitCount(val) <= i && i <= val)
                return (int) i;
            }
        return -1;
  }
}