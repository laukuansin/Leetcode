class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int max = 0;
        int left = 0;

        for(int i = 0 ; i < nums.size() ; i++)
        {
            int curNum = nums.get(i);
            hashMap.put(curNum,hashMap.getOrDefault(curNum,0)+1);
            max = Math.max(max,hashMap.get(curNum));

            if(i-left-max+1>k)
            {
                hashMap.put(nums.get(left),hashMap.get(nums.get(left))-1);
                left++;
            }

        }
        return max;
    }
}