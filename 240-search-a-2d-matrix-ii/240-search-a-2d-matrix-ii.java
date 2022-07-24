class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        boolean check = false;
        int row=matrix.length;
        int col=matrix[0].length;
          
        int start = 0;
        int end=row-1;

        while(start<=end)
        {
            int middle=(start+end)/2;
            if(matrix[middle][col-1]==target)
            {
                return true;
            }
            else if(target>matrix[middle][col-1]){
                start=middle+1;
            }
            else{
                if(binarySearch(matrix,middle,target))
                {
                    return true;
                }
                end=middle-1;
            }
        }
        return false;
        */
        int n=matrix.length, m=matrix[0].length;
        int i=0, j=m-1;
        while(i<n&&j>=0){
            if(target==matrix[i][j])
                return true;
            if(target>matrix[i][j])
                i+=1;
            else
                j-=1;
        }
        return false;
    }
    public boolean binarySearch(int[][] matrix,int found,int target)
    {
        int row=matrix.length;
        int col=matrix[0].length;
        int start=0;
        int end=col-1;
        while(start<=end)
        {
            int middle=(start+end)/2;
            if(matrix[found][middle]==target)
            {
                return true;
            }
            else if(matrix[found][middle]>target)
            {
                end=middle-1;
            }
            else{
                start=middle+1;
            }
        }
        return false;
    }
}