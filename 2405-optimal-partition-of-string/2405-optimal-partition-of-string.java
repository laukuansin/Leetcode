class Solution {
    public int partitionString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 1;
        char[] charArr = s.toCharArray();

        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(charArr[i]))
            {
                result++;
                map.clear();
                map.put(charArr[i],1);
            }
            else{
                map.put(charArr[i],map.getOrDefault(charArr[i],0)+1);
            }
        }

        return result;

    }
}