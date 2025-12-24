class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        

        int count = 0, total = 0;

        for(int i=0; i<apple.length; i++) {
            count += apple[i];
        }

        for(int i=0; i<capacity.length; i++) {
            total += capacity[i];
        }

        if(count == total) {
            return capacity.length;
        }

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // for(int i=0; i<capacity.length; i++) {
        //     pq.offer(capacity[i]);
        // }

        // int box = 0;
        // while(count>0 && !pq.isEmpty()) {
        //     box++;
        //     count -= pq.poll();
        // }

        Arrays.sort(capacity);

        int box = 0, i = capacity.length-1;
        while(count>0 && i>=0) {
            box++;
            count -= capacity[i--];
        }
        
        return box;
    }
}