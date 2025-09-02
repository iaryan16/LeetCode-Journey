class Solution {
    List<String> list = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        list.clear();
        helper(num,"" ,0 , 0,  0, target);
        return list;
    }

    public void helper(String num, String res, int idx, long prev, long ans, int target) {

        if(idx == num.length()) {
            if(ans == target) {
                list.add(res);
            }
            return; 
        }

        for (int i = idx; i < num.length(); i++) {
        
            if (i != idx && num.charAt(idx) == '0') 
                break;

            String part = num.substring(idx, i + 1);
            long curr = Long.parseLong(part);

            if(idx == 0) {
                helper(num, part, i+1, curr, curr, target);
            } else {
                helper(num, res+"+"+part, i+1, curr, ans+curr, target);
                helper(num, res+"-"+part, i+1, -curr, ans-curr, target);
                helper(num, res+"*"+part, i+1, prev*curr, ans-prev+prev*curr, target);
            }
        }
    }
}