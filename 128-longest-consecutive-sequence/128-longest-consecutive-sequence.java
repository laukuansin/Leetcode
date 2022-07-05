import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<1)
            return 0;
        int max = 1;
        Integer[] intArr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            intArr[i]=nums[i];
        }
        Set<Integer> hs = new HashSet<Integer>(Arrays.asList(intArr));
        List<Integer> aList = new ArrayList<Integer>(hs);
        Collections.sort(aList);
        int temp = 1;
        for(int i=0;i<aList.size()-1;i++)
        {
            if(aList.get(i)+1==aList.get(i+1))
            {
                temp++;
            }
            else{
                max=Math.max(max,temp);
                temp=1;
            }
        }
        return Math.max(max,temp);
    }
}