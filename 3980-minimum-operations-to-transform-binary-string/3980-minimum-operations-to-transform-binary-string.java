class Solution {
    public int minOperations(String s1, String s2) {
        
        int n = s1.length();

        if(n == 1 && s1.charAt(0) == '1' && s2.charAt(0) == '0') return -1;

        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();

        int ops = 0;
        for(int i=0; i<n; i++) {
            if(arr1[i] == '0' && arr2[i] == '1') {
                ops++;
                arr1[i] = '1';
            }
        }

        for(int i=0; i<n; i++) {
            if(arr1[i] == arr2[i]) continue;

            if(arr1[i] == '1') {
                if(i+1 < n) {
                    if(arr1[i+1] == '1') {
                        ops++;
                        arr1[i] = '0';
                        arr1[i+1] = '0';
                    } else if(arr1[i+1] == '0') {
                        ops += 2;
                        arr1[i] = '0';
                        arr1[i+1] = '0';
                    }
                } else if(i-1 >= 0) {
                    if(arr1[i-1] == '1') {
                        ops += 2;
                        arr1[i] = '0';
                        arr1[i-1] = '1';
                    } else if(arr1[i-1] == '0') {
                        ops += 2;
                        arr1[i] = '0';
                        arr1[i-1] = '0';
                    }
                }
            } else {
                ops++;
            }

        }
        return ops;
    } 
}