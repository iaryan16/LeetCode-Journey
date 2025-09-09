class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int i = 0;
        int j = 0;
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int idx2 = n/2;
        int idx1 = idx2 - 1;
        int ele1 = -1;
        int ele2 = -1;
        int c = 0;
        while (i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                if(c == idx1) ele1 = nums1[i];
                if(c == idx2) ele2 = nums1[i];
                c++;
                i++;
            } else {
                if(c == idx1) ele1 = nums2[j];
                if(c == idx2) ele2 = nums2[j];
                c++;
                j++;
            }
        }

        while(i < n1) {
            if(c == idx1) ele1 = nums1[i];
            if(c == idx2) ele2 = nums1[i];
            c++;
            i++;
        }

        while(j < n2) {
            if(c == idx1) ele1 = nums2[j];
            if(c == idx2) ele2 = nums2[j];
            c++;
            j++;
        }

        if(n % 2 != 0) {
            return ele2;
        }

        return ((double)ele1 + (double)ele2)/(double)2;

    }
}