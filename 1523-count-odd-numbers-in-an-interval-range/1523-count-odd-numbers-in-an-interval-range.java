class Solution {
    //Math Method
    /*
    *   Logic
    *   ________________________________________________________
    *   We will always refer to both even num to solve the issue
    *   Example 1: 
    *   Low: 2, High: 10
    *   2,3,4,5,6,7,8,9,10
    *   We just need to use High minus low and divided 2
    *   Formula: (High-Low)/2 = 4; Ans = 4
    *   
    *   Example 2:
    *   Low: 1, High: 11
    *   1,-----"2,3,4,5,6,7,8,9,10,"-----11   
    *   For both low and high are odd num case,
    *   We just need to take out the first num and last num, 
    *   then we can apply the formula for example 1.
    *   Formula: (High-Low-2)/2 +2 = 6;
    *   Deduct two is to take out 1 and 11. Then after we done calculation for 2~10,
    *   then we add on 2 back due to 1 and 11 also odd num.
    *   
    *   Example 3:
    *   Low: 1, High: 10 OR  Low: 2, High: 11
    *   1,----"2,3,4,5,6,7,8,9,10"  OR "2,3,4,5,6,7,8,9,10"----11
    *   For either one is odd num case.
    *   We just need to take out either first num or last num, 
    *   then we can apply the formula for example 1.
    *   Formula: (High-Low-1)/2 +1 = 5;
    *   Deduct one is to take out either 1 or 11. Then after we done calculation for 2~10,
    *   then we add on 1 back due to 1 or 11 is odd num.
    */
    public int countOdds(int low, int high) {
        if(low%2==0&&high%2==0)//both low and high are even num
        {
            return (high-low)/2;
        }
        else if(low%2!=0&&high%2!=0)//both low and high are odd num
        {
            return (high-low-2)/2+2;
        }
        else{//either one is even and odd num
            return (high-low-1)/2+1;
        }
    }
}