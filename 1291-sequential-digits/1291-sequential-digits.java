class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        int len = convert(low);
        int maxLen = convert(high);

        char arr[] = {'1', '2', '3', '4', '5', '6', '7', '8','9'};

        List<Integer> list = new ArrayList<>();
    
        while(len <= maxLen) {
            for(int i=0; i<10-len; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=i; j<i+len; j++) {
                    sb.append(arr[j]);
                }
                int val = Integer.parseInt(sb.toString());
                if(val >= low && val <= high) {
                    list.add(val);
                }
            }
        len++;
        }
        

        return list;

    }

    public int convert(int num) {
        int len = 0;
        int copy = num;
        while (copy > 0) {
            copy = copy / 10;
            len++;
        }

        return len;
    }

}