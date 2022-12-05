class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hashmap = new HashMap<>();
        hashmap.put('I',1);
        hashmap.put('V',5);
        hashmap.put('X',10);
        hashmap.put('L',50);
        hashmap.put('C',100);
        hashmap.put('D',500);
        hashmap.put('M',1000);
        
        char[] charArray = s.toCharArray();
        int total = 0;
        
        for(int i=0;i<s.length();i++)
        {
            char currentChar = charArray[i];
            if(i+1<s.length())
            {
                char nextChar = charArray[i+1];
                if(currentChar=='I')
                {
                    if(nextChar=='V'||nextChar=='X')
                    {
                        total = total +(hashmap.get(nextChar)-hashmap.get(currentChar));
                        i++;
                        continue;
                    }
                }
                else if(currentChar=='X')
                {
                    if(nextChar=='L'||nextChar=='C')
                    {
                        total = total +(hashmap.get(nextChar)-hashmap.get(currentChar));
                        i++;
                        continue;
                    }
                }
                else if(currentChar=='C')
                {
                    if(nextChar=='D'||nextChar=='M')
                    {
                        total = total +(hashmap.get(nextChar)-hashmap.get(currentChar));
                        i++;
                        continue;
                    }
                }
            }
            
            total+=hashmap.get(currentChar);
            
        }
        
        return total;
    }
}