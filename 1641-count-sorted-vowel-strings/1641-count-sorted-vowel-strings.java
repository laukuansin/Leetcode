class Solution {
    public int countVowelStrings(int n) {
        String[] arrVowel = {"a","e","i","o","u"};
        List<String> list = new ArrayList<>();
        helper(arrVowel,list,n,0,new StringBuilder());
        return list.size();
    }
    
    public void helper(String[] arrVowel,List<String>list,int n,int idx,StringBuilder sb)
    {
        if(sb.length()==n)
        {
            list.add(sb.toString());
            return;
        }
        
        for(int i=idx;i<arrVowel.length;i++)
        {
           
            sb.append(arrVowel[i]);
            helper(arrVowel,list,n,i,sb);
            sb.deleteCharAt(sb.length()-1);
            
        }
    }
}