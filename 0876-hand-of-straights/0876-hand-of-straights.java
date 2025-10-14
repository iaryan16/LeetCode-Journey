class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : hand){
            pq.add(i);
        }
        while(pq.size() != 0) {
            int start = pq.poll();

            for(int i=1; i<groupSize; i++) {
                if(pq.remove(start + i)) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}