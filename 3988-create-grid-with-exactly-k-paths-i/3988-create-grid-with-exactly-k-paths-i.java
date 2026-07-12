class Solution {
    String ans[];
    public String[] createGrid(int m, int n, int k) {
        ans = new String[m];
        if((m == 1 || n == 1) && k > 1) {
            return new String[0];
        } else if(m == 2 && n == 2 && k > 2){
            return new String[0];
        } else if(((m == 2 && n == 3) || (m == 3 && n == 2)) && k > 3) {
            return new String[0];
        } else if(m == 3 && n == 3 && k == 4) {
            return new String[] {"..#", "...", "#.."};
        }

        char arr[][] = new char[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || j == n-1) 
                    arr[i][j] = '.';
                else 
                    arr[i][j] = '#';
            }
        }
        k--;

        if(m < n) {
            int j = n-2;
            while(j >= 0 && k > 0) {
                arr[1][j] = '.';
                j--;
                k--;
            }
        } else {
            int i= 1;
            while(i < m && k > 0) {
                arr[i][n-2] = '.';
                i++;
                k--;
            }    
        }

        if(k>0)
            return new String[0];

        
        convert(arr);
        return ans;
    }

    public void convert(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            ans[i] = new String(arr[i]);
        }
    }
}