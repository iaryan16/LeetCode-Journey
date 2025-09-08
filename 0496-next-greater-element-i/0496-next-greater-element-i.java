class Solution {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[] = nextGreat(nums2);
    
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums2.length; i++) {
            map.put(nums2[i], arr[i]);
        }

        for(int i=0; i<nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }

    public static int[] nextGreat(int nums[]) {

        Stack<Integer> s = new Stack<>();

        int arr[] = new int[nums.length];

        for(int i=nums.length - 1; i>=0; i--) {
            while(!s.isEmpty() && nums[i] >= s.peek()) {
                s.pop();
            }
            if(s.isEmpty()) {
                arr[i] = -1;
            } else {
                arr[i] = s.peek();
            }
            s.push(nums[i]);
        }
        return arr;
    }
}