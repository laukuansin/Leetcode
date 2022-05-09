public class Solution {
    
    Dictionary<char,string> hashTable = new Dictionary<char,string>();
    public IList<string> LetterCombinations(string digits) {
        hashTable.Add('2',"abc");
        hashTable.Add('3',"def");
        hashTable.Add('4',"ghi");
        hashTable.Add('5',"jkl");
        hashTable.Add('6',"mno");
        hashTable.Add('7',"pqrs");
        hashTable.Add('8',"tuv");
        hashTable.Add('9',"wxyz");
                IList<string> list = new List<string>();

        if(digits=="")
        {
            return list;
        }
        helper(list,digits,0, new StringBuilder());
        return list;
    }
    
    public void helper(IList<string> list,string digits,int index,StringBuilder sb)
    {
        if(index==digits.Length)
        {
            list.Add(sb.ToString());
            return;
        }
        
        
        string curr = hashTable[digits[index]];//abc
        foreach(char c in curr.ToCharArray())// a b c
        {
            sb.Append(c);
            helper(list,digits,index+1,sb);
            sb.Remove(sb.Length-1,1);
        }
       
    }
}