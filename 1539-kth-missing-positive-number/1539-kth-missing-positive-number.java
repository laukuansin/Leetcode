class Solution {
    public int findKthPositive(int[] arr, int k) {
        int curIdx = 0;
        for(int i=1;i<=1000;i++)
        {
            if(curIdx<arr.length&&arr[curIdx]==i)
            {
                curIdx++;
                continue;
            }
            k--;
            if(k==0)
            {
                return i;
            }
        }
        return 1000+k;
    }
}