class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int left = matrix[i][j];
                int right = matrix[i][j];
                int mid = matrix[i][j]+matrix[i-1][j];
                if(j>0&&j<n-1)
                {
                    left += matrix[i-1][j-1];
                    right += matrix[i-1][j+1];
                    matrix[i][j] = Math.min(left,Math.min(right,mid));
                }
                else if(j>0)
                {
                    left += matrix[i-1][j-1];
                    matrix[i][j] = Math.min(left,mid);
                }
                else if(j<n-1)
                {
                    right += matrix[i-1][j+1];
                    matrix[i][j] = Math.min(right,mid);
                }
                if(i==n-1)
                {
                    min = Math.min(min,matrix[i][j]);
                }
            }
        }
        return min==Integer.MAX_VALUE?matrix[0][0]:min;
    }
}