class Solution {
    public int bestClosingTime(String customers) {
        int min = 0;
     
        for(char customer : customers.toCharArray())
        {
            if(customer=='Y')
            {
                min++;
            }
        }

        int curMin = min;
        int index = 0;

        for(int i = 0 ; i < customers.length() ; i++)
        {
            if(customers.charAt(i)=='Y')
            {
                curMin--;
            }
            else{
                curMin++;
            }

            if(curMin<min)
            {
                min = curMin;
                index = i+1;
            }
        }

        return index;
    }
}