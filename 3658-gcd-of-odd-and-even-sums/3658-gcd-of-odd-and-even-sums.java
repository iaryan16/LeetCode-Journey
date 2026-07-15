class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOfOdd = sumOfNumber(n, 1);
        int sumOfEven = sumOfNumber(n, 2);
        
        int ans = gcd(sumOfOdd, sumOfEven);

        return ans;
    }

    public int sumOfNumber(int n, int first) {
        int sum = 0;
        while(n > 0) {
            sum += first;
            first += 2;
            n--;
        }
        return sum;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}