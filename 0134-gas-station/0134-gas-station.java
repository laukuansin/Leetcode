class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = -1;
        int total = 0;
        for(int i=0;i<gas.length;i++)
        {
            int leftOverGas = gas[i]-cost[i];
            total+=leftOverGas;
        }
        if(total<0)
            return -1;
        int collectedGas = 0;

        for(int i=0;i<gas.length;i++)
        {
            int leftOverGas = gas[i]-cost[i];
            collectedGas +=leftOverGas;
            if(leftOverGas<0)
            {
                if(collectedGas<0)
                {
                    collectedGas = 0;
                    idx = -1;
                    continue;
                }
            }
            else{
                if(idx==-1)
                {
                    idx = i;
                }
            }
        }
        
        return idx;
    }
}