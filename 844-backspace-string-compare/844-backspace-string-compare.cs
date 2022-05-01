public class Solution {
    public bool BackspaceCompare(string s, string t) {
        Stack<char> stackS = new Stack<char>();
        Stack<char> stackT = new Stack<char>();
        
        foreach(char c in s.ToCharArray())
        {
            if(c=='#')
            {
                if(stackS.Count==0)
                {
                    continue;
                }
                stackS.Pop();
            }
            else{
                stackS.Push(c);
            }
        }
        foreach(char c in t.ToCharArray())
        {
            if(c=='#')
            {
                if(stackT.Count==0)
                {
                    continue;
                }
                stackT.Pop();
            }
            else{
                stackT.Push(c);
            }
        }
        
        if(stackS.Count()!=stackT.Count())
        {
            return false;
        }
        
        while(stackS.Count()!=0&&stackT.Count()!=0)
        {
            char chrS = stackS.Pop();
            char chrT= stackT.Pop();
            if(chrS!=chrT)
            {
                return false;
            }
        }
        return true;
    }
}