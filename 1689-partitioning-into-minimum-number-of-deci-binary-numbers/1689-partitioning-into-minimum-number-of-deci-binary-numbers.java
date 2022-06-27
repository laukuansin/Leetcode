class Solution {
    public int minPartitions(String n) {
        int max = -1;
        for(char c: n.toCharArray())
        {
            int num = c-'0';
            max=Math.max(num,max);
        }
        return max;
    }
}