class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int selectedIdx = -1;

        for(int i = 0 ; i < row ; i++)
        {
            if(target<=matrix[i][col-1])
            {
                selectedIdx = i;
                break;
            }
        }

        if(selectedIdx == -1)
            return false;

        int start = 0;
        int end = col-1;

        while(start<=end)
        {
            int middle = (end-start)/2+start;

            if(matrix[selectedIdx][middle]==target)
            {
                return true;
            }
            else if(matrix[selectedIdx][middle]>target){
                end = middle-1;
            }   
            else{
                start = middle+1;
            }
        }

        return false;
    }

}