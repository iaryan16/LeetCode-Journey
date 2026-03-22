class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0 ;i<4;i++){
            mat = rotate(mat);
            if(areArraysEqual(mat,target))
                return true;
        }
        return false;
        

    }
    public static int[][] rotate(int arr[][]) {
        int newArr[][] = new int [arr.length][arr[0].length];
        int col = arr.length-1;
        for(int i =0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                newArr[j][col-i] = arr[i][j];
            }
        }
        return newArr;
    } 
    public static boolean areArraysEqual(int[][] arr1, int[][] arr2) { 
        if (arr1.length != arr2.length) { 
            return false; 
        } 
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) { 
                return false; 
            } 
            for (int j = 0; j < arr1[i].length; j++) { 
                if (arr1[i][j] != arr2[i][j]) { 
                    return false; 
                } 
            } 
        } 
        return true;
    }
}