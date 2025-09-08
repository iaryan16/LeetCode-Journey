class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int arr[] = new int[nums.length];
        int n = nums.length;

        for(int i=n*2 - 1; i>=0; i--) {
            while(!s.isEmpty() && nums[i%n] >= s.peek()) {
                s.pop();
            }
            if(i<n) {
                if(s.isEmpty()) arr[i] = -1;
                else    arr[i] = s.peek();
            }
            s.push(nums[i%n]);
        }
        return arr;
    }
}