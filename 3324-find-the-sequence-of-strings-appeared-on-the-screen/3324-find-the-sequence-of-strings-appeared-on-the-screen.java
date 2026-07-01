class Solution {
   
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        for(char ch : target.toCharArray()) {
            char start = 'a';
            curr.append(start);
            ans.add(curr.toString());

            while(start != ch) {
                int idx = curr.length()-1;
                char last = curr.charAt(idx);
                char nextCh = (last == 'z') ? 'a' : (char)(last + 1);
                curr.setCharAt(idx, nextCh);
                ans.add(curr.toString());
                start++;
            }
        }
        return ans;
    }

    // public void solve(int i, String target, String curr) {

    //     if(i >= target.length()) return;

    //     for(char ch = 'a'; ch <= 'z'; ch++) {
    //         String s = curr.toString();
    //         if(ch == target.charAt(i)) {
    //             curr += ch;
    //             ans.add(curr);
    //             break;
    //         } else {
    //             s += ch;
    //             ans.add(s);
    //         }
    //     }

    //     solve(i+1, target, curr);
    // }
}