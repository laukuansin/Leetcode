import java.util.Hashtable;
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<Pair<Integer,Integer>> a = getOneList(img1);
        List<Pair<Integer,Integer>> b = getOneList(img2);
        Hashtable<Pair<Integer,Integer>,Integer> ht = new Hashtable<>();
        int maxOverLap = 0;
        for(Pair<Integer,Integer> pairA:a)
        {
            for(Pair<Integer,Integer> pairB:b)
            {
                Pair<Integer,Integer> vec = new Pair<Integer,Integer>(pairB.getKey()-pairA.getKey(),pairB.getValue()-pairA.getValue());
                
                if(ht.containsKey(vec))
                {
                    ht.put(vec,ht.get(vec)+1);
                }
                else{
                    ht.put(vec,1);
                }
                maxOverLap = Math.max(maxOverLap,ht.get(vec));
            }
        }
        return maxOverLap;
    }
    
    public List<Pair<Integer,Integer>> getOneList(int[][] img)
    {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        
        for(int i=0;i<img.length;i++)
        {
            for(int j=0;j<img.length;j++)
            {
                if(img[i][j]==1)
                {
                    list.add(new Pair<Integer,Integer>(i,j));
                }
            }
        }
        return list;
    }
}