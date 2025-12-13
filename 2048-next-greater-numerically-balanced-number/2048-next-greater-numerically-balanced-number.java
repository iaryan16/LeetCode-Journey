class Solution {
    public int nextBeautifulNumber(int n) {
        
        n=n+1;
        while(n>0) {
            if(check(n)) {
                break;
            }
            ++n;
        }
        return n;
    }

    public boolean check(int num) {

        // 1st  

        // String str = String.valueOf(num);

        // Map<Character, Integer> freq = new HashMap<>();

        // for(int i=0; i<str.length(); i++) {
        //     char ch = str.charAt(i);
        //     freq.put(ch, freq.getOrDefault(ch, 0)+1);
        // }

        // for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
        //     if(entry.getKey()-'0' != entry.getValue()) {
        //         return false;
        //     }
        // }
        // return true;

        // 2nd

        int freq[] = new int[10];

        while(num>0) {
            int rem = num % 10;
            freq[rem]++;
            num = num/10;
        }

        for(int i=0; i<10; i++) {
            if(freq[i] != 0 && freq[i] != i) {
                return false;
            }
        }

        return true;
    }
}