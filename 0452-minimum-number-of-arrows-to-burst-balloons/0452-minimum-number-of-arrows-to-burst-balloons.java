class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,new Comparator<int[]>()
        {
            public int compare(int[] a,int[] b)
            {
                return Integer.compare(a[0],b[0]);
            }
        });
        int res = 1;
        int[] curArr = points[0];
        for(int i=1;i<points.length;i++)
        {
            int[] nextArr = points[i];
            if(nextArr[0]>curArr[1])
            {
                res++;
                curArr = nextArr;
            }
            else{
                curArr[0] = nextArr[0];
                curArr[1] = Math.min(curArr[1],nextArr[1]);
            }
        }
        return res;
    }
}