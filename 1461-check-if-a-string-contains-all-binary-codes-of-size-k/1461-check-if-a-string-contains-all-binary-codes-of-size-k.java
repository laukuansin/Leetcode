class Solution {
    public boolean hasAllCodes(String s, int k) {
        int size = (int)Math.pow(2,k);
        HashSet<Integer> set=new HashSet();  

         for(int i =0;i<=s.length()-k;i++)  
         {
             String str = s.substring(i,i+k);
             int num =  Integer.parseInt(str, 2);
             if(!set.contains(num))
             {
                 
                 set.add(num);
                 size--;
                 if(size==0)
                     return true;
             }
         }
    
        return false;
    }
}