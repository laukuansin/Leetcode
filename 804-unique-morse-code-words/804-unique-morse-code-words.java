import java.util.Hashtable;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        /*
        Hashtable<Character,String> ht = new Hashtable<>();
          
        ht.put('a',".-");ht.put('b',"-...");ht.put('c',"-.-.");
        ht.put('d',"-..");ht.put('e',".");ht.put('f',"..-.");
        ht.put('g',"--.");ht.put('h',"....");ht.put('i',"..");
        ht.put('j',".---");ht.put('k',"-.-");ht.put('l',".-..");
        ht.put('m',"--");ht.put('n',"-.");ht.put('o',"---");
        ht.put('p',".--.");ht.put('q',"--.-");ht.put('r',".-.");
        ht.put('s',"...");ht.put('t',"-");ht.put('u',"..-");
        ht.put('v',"...-");ht.put('w',".--");ht.put('x',"-..-");
        ht.put('y',"-.--");ht.put('z',"--..");
        */
        HashSet<String> set=new HashSet();
        String[] strArr = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for(String str:words)
        {
            char[] charArr= str.toCharArray();
            String tmp ="";
            for(char c:charArr)
            {
                tmp+=strArr[c-'a'];
            }
            set.add(tmp);
        }
        
        return set.size();
    }
}