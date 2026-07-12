class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        
        String s[] = startTime.split(":");
        String e[] = endTime.split(":");

        int sh = Integer.parseInt(s[0]);
        int sm = Integer.parseInt(s[1]);
        int ss = Integer.parseInt(s[2]);

        int eh = Integer.parseInt(e[0]);
        int em = Integer.parseInt(e[1]);
        int es = Integer.parseInt(e[2]);

        long st = sh*60*60 + sm*60 + ss;
        long et = eh*60*60 + em*60 + es;

        return (int)(et - st);


        
    }
}