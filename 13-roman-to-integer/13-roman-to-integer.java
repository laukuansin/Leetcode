import java.util.Hashtable;
class Solution {
    public int romanToInt(String s) {
        Hashtable<Character,Integer> ht= new Hashtable<Character,Integer>();
        ht.put('I',1);
        ht.put('V',5);
        ht.put('X',10);
        ht.put('L',50);
        ht.put('C',100);
        ht.put('D',500);
        ht.put('M',1000);
        int ans=0;
        char[] charArr=s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            int cur = ht.get(charArr[i]);
            if(i+1<s.length())
            {
               int next=ht.get(charArr[i+1]);
                
                if(cur<next)
                {
                    ans=ans+next-cur;
                    i++;
                }
                else{
                    ans+=cur;
                }
            }
            else{
                ans+=cur;
            }
            
        }
        return ans;
    }
}