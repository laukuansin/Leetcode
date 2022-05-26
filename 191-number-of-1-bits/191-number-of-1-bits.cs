public class Solution {
    public int HammingWeight(uint n) {
        int intN = (int)n;
        int ans=0;
        string binary = Convert.ToString(intN, 2);
        char[] charArr=binary.ToCharArray();
        foreach(char c in charArr)
        {
            if(c=='1')
            {
                ans++;
            }
        }
        //Console.WriteLine(binary);
        return ans;
    }
}