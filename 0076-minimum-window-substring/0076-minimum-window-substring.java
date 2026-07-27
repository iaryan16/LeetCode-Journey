class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int n = s.length();
        int m = t.length();

        if(m > n) return "";

        for(int i=0; i<m; i++) {
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }

        char arr[] = s.toCharArray();
        String ans = "";

        int l=0, r=0, min=Integer.MAX_VALUE;
        while(r < n ) {
            map1.put(arr[r], map1.getOrDefault(arr[r], 0)+1);
            
            while(check(map1, map2)) {
                if(min > r-l+1) {
                    min = r-l+1;
                    ans = s.substring(l, r+1);
                }
                map1.put(arr[l], map1.get(arr[l])-1);
                l++;
            }
            r++;
        }
        return ans;
    }

    public boolean check(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {

        for(Map.Entry<Character, Integer> it : map2.entrySet()) {
            char key = it.getKey();
            if(map1.getOrDefault(key, 0) < map2.get(key)) {
                return false;
            }
        }

        return true;
    }
}