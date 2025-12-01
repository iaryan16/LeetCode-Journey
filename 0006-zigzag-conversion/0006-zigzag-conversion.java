class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) 
            return s;

        int n = s.length();
        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int idx = 0;
        int c = 1;
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            list.get(idx).append(ch);
            if(idx == 0) {
                c = 1;
            }
            else if(idx == numRows-1) {
                c = -1;
            }

            idx += c;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}