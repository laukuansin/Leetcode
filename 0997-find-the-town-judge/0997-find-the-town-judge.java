class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] peopleTrust = new int[n+1][2];
        for(int[] trustPair:trust)
        {
            peopleTrust[trustPair[0]][0]++;
            peopleTrust[trustPair[1]][1]++;
        }
        for(int i=1;i<=n;i++)
        {
            int[] people = peopleTrust[i];
            if(people[0]==0&&people[1]==n-1)
            {
                return i;
            }
        }

        return -1;
    }
}