class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        String[] strArr=s.split(" ");
        return strArr[strArr.length-1].length();
        //return s.trim().split(" ")[s.trim().split(" ").length-1].length();
    }
}