class Solution {
    public long gcdSum(int[] nums) {
        
        int n = nums.length;
        int maxi[] = new int[n];

        maxi[0] = nums[0];
        for(int i=1; i<n; i++) {
            maxi[i] = Math.max(maxi[i-1], nums[i]);
        }

        long prefixGcd[] = new long[n];
        for(int i=0; i<n; i++) {
            prefixGcd[i] = gcd(maxi[i], nums[i]);
        }

        Arrays.sort(prefixGcd);

        int l=0, r=n-1;
        long sum = 0;
        while(l < r) {
            sum += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }

        return sum;

    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}