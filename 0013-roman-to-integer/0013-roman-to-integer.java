class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);

        int ans = 0;
        
        for(int i = s.length()-1; i >=0 ; i--)
        {
            if(i==s.length()-1)
            {
                ans+=hashMap.get(s.charAt(i));
            }
            else{
                if(s.charAt(i)=='I')
                {
                    if(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')
                    {
                        ans-=hashMap.get(s.charAt(i));
                    }
                    else{
                        ans+=hashMap.get(s.charAt(i));
                    }
                }
                else if(s.charAt(i)=='X')
                {
                    if(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')
                    {
                        ans-=hashMap.get(s.charAt(i));
                    }
                    else{
                        ans+=hashMap.get(s.charAt(i));
                    }
                }
                else if(s.charAt(i)=='C')
                {
                    if(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')
                    {
                        ans-=hashMap.get(s.charAt(i));
                    }
                    else{
                        ans+=hashMap.get(s.charAt(i));
                    }
                }
                else{
                    ans+=hashMap.get(s.charAt(i));
                }
            }
        }
        return ans;
    }
}