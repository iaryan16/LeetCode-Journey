class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();

        for(char ch : brokenLetters.toCharArray()) {
            set.add(ch);
        }

        String[] arr = text.split(" ");
        int c = 0;

        for (String word : arr) {
            boolean flag = true;

            for (char ch : word.toCharArray()) {
                if (set.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                c++;
            }
        }
        return c;
    }
}