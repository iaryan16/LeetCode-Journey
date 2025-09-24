class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        StringBuilder res = new StringBuilder("");
        if((numerator < 0 && denominator > 0) || numerator > 0 && denominator < 0) {
            res.append("-");
        }

        long num = (long)Math.abs((long)numerator);
        long den = (long)Math.abs((long)denominator);

        long q = num / den;
        long r = num % den;

        res.append(String.valueOf(q));

        if(r == 0) {
            return res.toString();
        }

        res.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while(r != 0) {

            if(map.containsKey(r)) {
                int pos = map.get(r);
                res.insert(pos, "(");
                res.append(")");
                return res.toString();
            } else {
                map.put(r, res.length());
                r *= 10;
                q = r / den; 
                res.append(String.valueOf(q));
                r = r % den;
            }
            
        }

        return res.toString();
    }
}
