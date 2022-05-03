public class Solution {
    public int FindUnsortedSubarray(int[] nums) {
        /*  selection sort method
        int left = nums.Length,right=0;
        
        for(int i=0;i<nums.Length-1;i++)
        {
            for(int j=i+1;j<nums.Length;j++)
            {
                if(nums[i]>nums[j])
                {
                    right=Math.Max(right,j);
                    left=Math.Min(left,i);
                }
            }
        }
        
        return right-left<0?0:right-left+1;
        */
        
         Stack <int> stack = new Stack <int> ();
        int l = nums.Length, r = 0;
        for (int i = 0; i < nums.Length; i++) {
            while (stack.Count!=0&& nums[stack.Peek()] > nums[i])
            {
                l = Math.Min(l, stack.Pop());
            }
            stack.Push(i);
        }
        stack.Clear();
        for (int i = nums.Length - 1; i >= 0; i--) {
            while (stack.Count!=0 && nums[stack.Peek()] < nums[i])
            { 
                r = Math.Max(r, stack.Pop());
            }
            stack.Push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}