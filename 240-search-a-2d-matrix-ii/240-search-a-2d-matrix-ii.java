class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row=matrix.length, col=matrix[0].length;
        int start=0, end=col-1;
        while(start<row&&end>=0){
            if(target==matrix[start][end])
                return true;
            if(target>matrix[start][end])
                start+=1;
            else
                end-=1;
        }
        return false;
    }

}