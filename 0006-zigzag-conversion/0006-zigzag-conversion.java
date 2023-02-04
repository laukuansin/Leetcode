class Solution {
    public String convert(String s, int numRows) {
        //Edge case: When row =1, mean no need Zig Zag
        if(numRows==1)
            return s;

        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        //The distance of next character in zigzag form
        //Example:
        /*
        *   A   E
        *   B D F
        *   C   G
        *   
        *   The Distance from A to E is 4 (0->4)
        *   The Distance from B to D and D to F is 4 (1->3->5)
        *   The Distance from C to G is 4 (2->6)
        */ 
        int nextCharDistance = (numRows-1)*2;

        for(int i=0;i<numRows;i++)
        {
            int x = i*2;
            if(i==0)
            {
                x = nextCharDistance;
            }
            //First row and last row have same nextCharDistance
            
            int start = i;
            while(start<s.length())
            {
                sb.append(charArr[start]);
                //First row and last row no have character in between one cycle
                if(x!=nextCharDistance)
                {
                    x = Math.abs(x-nextCharDistance);
                }
                start+=x;
            }
        }

        return sb.toString();
    }
}