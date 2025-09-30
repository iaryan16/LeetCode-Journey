class Solution {
    public int compareVersion(String version1, String version2) {
        int idx1 = 0, idx2 = 0;
        while(idx1 < version1.length() || idx2 < version2.length()){

            int num1 = 0;
            while(idx1 < version1.length() && version1.charAt(idx1) != '.'){
                num1 = num1 * 10 + (version1.charAt(idx1) - '0');
                idx1++;
            }

            int num2 = 0;
            while(idx2 < version2.length() && version2.charAt(idx2) != '.'){
                num2 = num2 * 10 + (version2.charAt(idx2) - '0');
                idx2++;
            }

            if(num1 > num2 ){
                return 1;
            } else if(num1 < num2){
                return -1;
            } else {
                idx1++;
                idx2++;
            }
        }
        return 0;
    }
}