class Solution {
    public String smallestSubsequence(String s) {
        
        // char arr[] = new char[26];
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if(set.contains(ch)) 
                continue;
                
            while(!st.isEmpty() && st.peek() > ch && i < map.getOrDefault(st.peek(), -1)) {
                set.remove(st.pop());
            }

            st.push(ch);
            set.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }   

        return sb.reverse().toString();
    }


    
}