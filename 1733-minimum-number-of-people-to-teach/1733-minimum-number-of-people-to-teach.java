class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = friendships.length;

        Set<Integer> user = new HashSet<>();
        for(int i=0; i<m; i++) {
            int u = friendships[i][0];
            int v = friendships[i][1];
            
            Set<Integer> set =Arrays.stream(languages[u-1])
                         .boxed()
                         .collect(Collectors.toSet());

            boolean talk = false;

            for(int j : languages[v-1]) {
                if(set.contains(j)) {
                    talk = true;
                    break;
                }
            }

            if(!talk) {
                user.add(u);
                user.add(v);
            } 
        }

        int lang[] = new int[n+1];
        int max = 0;
        for(int i : user) {
            for(int j : languages[i-1]) {
                lang[j]++;
                max = Math.max(lang[j], max);
            }
        }

        return user.size() - max;

    }
}