class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); 
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            maxPQ.add(nums[i]);
        }
        
        for(int i=0;i<k;i++)
        {
            int temp =maxPQ.poll();
            if(i==k-1)
            {
                ans=temp;
            }
        }
        return ans;
    }
}