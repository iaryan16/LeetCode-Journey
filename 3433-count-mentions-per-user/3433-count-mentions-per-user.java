class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {  

        int count[] = new int[numberOfUsers];
        int userOff[] = new int[numberOfUsers];

        events.sort((a, b) -> {
            int x = Integer.parseInt(a.get(1));
            int y = Integer.parseInt(b.get(1));
            if( x == y) {
                return b.get(0).compareTo(a.get(0));
            }
            return x - y;
        });

        for(int i=0; i<events.size(); i++) {
            String text = events.get(i).get(0);
            int time = Integer.parseInt(events.get(i).get(1));
            String ids[] = events.get(i).get(2).split(" ");

            if(text.equals("MESSAGE")) {
                increase(ids, count, userOff, time);
            } else if(text.equals("OFFLINE")) {
                int id = Integer.parseInt(events.get(i).get(2));
                int ts = Integer.parseInt(events.get(i).get(1));
                userOff[id] = ts;
            }
        }
        return count;
    }

    public void increase(String ids[], int count[], int userOff[], int time) {
        

        for(String id : ids) {
            if(id.equals("ALL")) {
                for(int i=0; i<count.length; i++)   count[i]++;
            } else if(id.equals("HERE")) {
                for(int i=0; i<count.length; i++) {
                    if(userOff[i] == 0 || userOff[i]+60 <= time)   count[i]++;
                }
            } else {
                int curr = Integer.parseInt(id.substring(2));
                count[curr]++;
            }
        }
    }
}