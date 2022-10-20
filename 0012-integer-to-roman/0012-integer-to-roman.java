import java.util.Hashtable;
class Solution {
    public String intToRoman(int num) {
        Hashtable<Integer,String> ht = new Hashtable<>();
        ht.put(1,"I");
        ht.put(4,"IV");
        ht.put(5,"V");
        ht.put(9,"IX");
        ht.put(10,"X");
        ht.put(40,"XL");
        ht.put(50,"L");
        ht.put(90,"XC");
        ht.put(100,"C");
        ht.put(400,"CD");
        ht.put(500,"D");
        ht.put(900,"CM");
        ht.put(1000,"M");
        
        StringBuilder sb = new StringBuilder();
        int multiple = 1;
        
        while(num!=0)
        {
            int ones = num%10;
            int multipleWithOnes = ones*multiple;// 4, 90, 900, 1000
            
            num/=10;
            if(ones>1&&ones<4) 
            {
                for(int i=0;i<ones;i++)
                {
                    sb.insert(0,ht.get(1*multiple));
                }
            }
            else if(ones>5&&ones<9)
            {   
                for(int i=0;i<ones-5;i++)
                {
                    sb.insert(0,ht.get(1*multiple));
                }
                sb.insert(0,ht.get(5*multiple));
            }
            else if(ones==0)
            {
                
                multiple*=10;
                continue;
            }
            else 
            {
                sb.insert(0,ht.get(multipleWithOnes));
            }
            multiple*=10;
        }
        
        return sb.toString();
    }
}