class Spreadsheet {
    
    int grid[][];
    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int r = Integer.parseInt(cell.substring(1))-1;
        int c = cell.charAt(0) - 'A';
        grid[r][c] = value;
    }
    
    public void resetCell(String cell) {  
        int r = Integer.parseInt(cell.substring(1))-1;
        int c = cell.charAt(0) - 'A';
        grid[r][c] = 0;

    }
    
    public int getValue(String formula) {
        int idx = -1;
        for(int i=0; i<formula.length(); i++) {
            if(formula.charAt(i) == '+') {
                idx = i;
                break;
            }
        }

        String leftPart = formula.substring(1,idx);
        String rightPart = formula.substring(idx+1, formula.length());
        int val1=0, val2=0;
        if(Character.isLetter(leftPart.charAt(0))) {
            int r = Integer.parseInt(leftPart.substring(1))-1;
            int c = leftPart.charAt(0) - 'A';
            val1 = grid[r][c];
        } else {
            val1 = Integer.parseInt(leftPart);
        }

        if(Character.isLetter(rightPart.charAt(0))) {
            int r = Integer.parseInt(rightPart.substring(1))-1;
            int c = rightPart.charAt(0) - 'A';
            val2 = grid[r][c];
        } else {
            val2 = Integer.parseInt(rightPart);
        }

        return val1+val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */