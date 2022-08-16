import java.util.Hashtable;
class Solution {
    public int firstUniqChar(String s) {
        //Queue<Character> q = new LinkedList<>();
        Hashtable<Character,Integer> ht =new Hashtable<>();
        char[] charArr = s.toCharArray();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<charArr.length;i++)
        {
            if(ht.containsKey(charArr[i]))
            {
                ht.put(charArr[i],Integer.MAX_VALUE);
            }
            else{
                ht.put(charArr[i],i);
            }
        }
          for(Map.Entry<Character,Integer> m:ht.entrySet()){  
              if(ans>m.getValue())
              {
                  ans=m.getValue();
              }
          }  
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}