class Solution {
    // int dp[][] = new int[50001][50001];

    public int[] gcdValues(int[] nums, long[] queries) {

        int n = nums.length;

        int max = 0;
        for(int i=0; i<n; i++) max = Math.max(max, nums[i]);

        int freq[] = new int[max+1];
        for(int i=0; i<n; i++) freq[nums[i]]++;
        
        long pairs[] = new long[max+1];
        for(int i=max; i>0; i--) {
            long c = 0;

            for(int j=i; j<= max; j+=i) {
                c += freq[j];
            }

            pairs[i] = (c * (c-1))/2;

            for(int j=2 * i; j<= max; j+=i) {
                pairs[i] -= pairs[j];
            }
        }

        long[] prefix = new long[max+1];

        prefix[0] = pairs[0];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + pairs[i];
        }

        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = getValue(prefix, queries[i]);
        }

        return ans;
    }

    static int getValue(long[] prefix, long k) {
        int low = 0, high = prefix.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (prefix[mid] > k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
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