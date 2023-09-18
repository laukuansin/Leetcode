class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int row = mat.length;
        int col = mat[0].length;
        int[] ans = new int[k];

        for(int i = 0 ; i < row ; i ++)
        {
            int start = 0;
            int end = col;
            while(start<end)
            {
                int middle = (end-start)/2+start;
                if(mat[i][middle]==0)
                {
                    end = middle;
                }
                else{
                    start = middle+1;
                }
            }
            pq.add(new int[]{start,i});
        }

        int index = 0;
        while(index<k)
        {
            ans[index++]=pq.poll()[1];
        }

        return ans;
    }
}