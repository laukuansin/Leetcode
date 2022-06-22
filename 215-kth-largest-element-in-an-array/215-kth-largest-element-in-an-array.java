class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
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
        */
        
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    
    private int quickSelect(int[] nums,int left,int right,int k)
    {
        if(left==right)
        {
            return nums[left];
        }
        
        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex=partition(nums,left,right,pIndex);
        
        if(k==pIndex)
        {
            return nums[k];
        }
        else if(k<pIndex)
        {
            return quickSelect(nums,left,pIndex-1,k);
        }
        else{
            return quickSelect(nums,pIndex+1,right,k);
        }
    }
    
    private int partition(int[] nums,int left, int right, int index)
    {
        int pivot=nums[index];
        int temp = nums[right];
        nums[index]=temp;
        nums[right]=pivot;
        index=left;
        
        for(int j=left;j<=right;j++)
        {
            if(nums[j]<=pivot)
            {
                int temp1 = nums[index];
                nums[index]=nums[j];
                nums[j]=temp1;
                index++;
            }
            
        }
        return index-1;
    }
}