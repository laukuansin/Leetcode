import java.lang.*;

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int tests = minutesToTest/minutesToDie + 1;
        
            return (int)Math.ceil(Math.log(buckets)/Math.log(tests));
    }
}