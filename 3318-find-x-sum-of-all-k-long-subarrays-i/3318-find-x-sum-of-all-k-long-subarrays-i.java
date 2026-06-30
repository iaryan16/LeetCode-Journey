class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        
        int max = 0;
        int n = nums.length;
        int sums[] = new int[n-k+1];
        

        for(int i=0; i<n-k+1; i++) {
            sums[i] = sum(nums, i, i+k-1, x);
        }

        return sums;
        
    }

    public int sum(int arr[], int si, int ei, int x) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if(a[1] != b[1]) {
                    return b[1]-a[1];
                }
                return b[0]-a[0];
            });

        for(int i=si; i<=ei; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});
        }

        int sum = 0;

        if(pq.size() < x) {
            for(int i=si; i<=ei; i++) {
                sum += arr[i];
            }
        } else {
            while(x-- > 0) {
                sum += pq.peek()[0] * pq.poll()[1];
            }
        }

        return sum;


    }
}