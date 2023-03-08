class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for(int pile:piles)
        {
            right = Math.max(right,pile);
        }
        
        while(left<right)
        {
            int mid = left+(right-left)/2;
            int neededHour = 0;
            for(int pile:piles)
            {
                neededHour += pile/mid;
                neededHour += pile%mid==0?0:1;
            }
            if(neededHour>h)
            {
                left = mid+1;
            }
            else
            {
                right = mid;
            }
        }
        return left;
    }
}