import java.util.Hashtable;
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        int res = 0;
        
        while(queue.size()!=0)
        {
            int size = queue.size();
            for(int j=0;j<size;j++)
            {
                String temp = queue.poll();
            
                if(temp.equals(end))
                {
                    return res;
                }
                char[] geneArr = new char[]{'A','C','G','T'};
                for(char gene:geneArr)
                {
                    for(int i=0;i<temp.length();i++)
                    {
                        String modifyStr = temp.substring(0,i) + gene + temp.substring(i+1);
                        if(!set.contains(modifyStr)&&Arrays.asList(bank).contains(modifyStr))
                        {
                            set.add(modifyStr);
                            queue.add(modifyStr);
                        }
                    }
                }
               
            }
             res++;
        }
        
        return -1;
        
    }
}