class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        if(digits.equals(""))
            return ans;
        HashMap<Character,String[]> hashMap = new HashMap<>();
        hashMap.put('2',new String[]{"a","b","c"});
        hashMap.put('3',new String[]{"d","e","f"});
        hashMap.put('4',new String[]{"g","h","i"});
        hashMap.put('5',new String[]{"j","k","l"});
        hashMap.put('6',new String[]{"m","n","o"});
        hashMap.put('7',new String[]{"p","q","r","s"});
        hashMap.put('8',new String[]{"t","u","v"});
        hashMap.put('9',new String[]{"w","x","y","z"});
        helper(ans,new StringBuilder(),0,digits,hashMap);
        return ans;
    }

    public void helper(List<String> ans,StringBuilder sb,int index,String digits,HashMap<Character,String[]>hashMap)
    {
        if(sb.length()==digits.length())
        {
            ans.add(new String(sb.toString()));
            return;
        }

        for(int i = index ; i < digits.length() ; i++)
        {
            String[] stringArr = hashMap.get(digits.charAt(i));
            for(String str:stringArr)
            {
                sb.append(str);
                helper(ans,sb,i+1,digits,hashMap);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}