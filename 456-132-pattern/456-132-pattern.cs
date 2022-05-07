public class Solution {
    public bool Find132pattern(int[] nums) {
        Stack<int> stack = new Stack<int>();
        int s3=int.MinValue;
        int n =nums.Length;
        
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]<s3)
            {
                return true;
            }
            else{
                while(stack.Count!=0&&nums[i]>stack.Peek())
                {
                    s3=stack.Pop();
                }
            }
            stack.Push(nums[i]);
        }
        
        return false;
       
    }
}