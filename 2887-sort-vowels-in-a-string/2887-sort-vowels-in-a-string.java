class Solution {
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for(char ch : s.toCharArray()) {
            if(set.contains(ch))
                list.add(ch);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder("");
        int k=0;
        for(char ch : s.toCharArray()) {
            if(set.contains(ch))
                sb.append(list.get(k++));
            else 
                sb.append(ch);
        }
                  
        return sb.toString();
    }
}