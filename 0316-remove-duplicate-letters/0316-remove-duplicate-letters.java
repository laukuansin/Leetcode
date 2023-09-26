class Solution {
    public String removeDuplicateLetters(String s) {
        //StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] used = new boolean[26];

        for(char c : s.toCharArray())
            count[c-'a']++;

        for(char c : s.toCharArray())
        {
            count[c-'a']--;

            if(used[c-'a'])
                continue;
            
            while(stack.size()>0 && stack.peek() > c && count[stack.peek()-'a']>0)
            {
                used[stack.peek()-'a'] = false;
                stack.pop();
            }
            
            stack.push(c);
            used[c-'a'] = true;
        }
        
        String ans = "";
        while(!stack.isEmpty())
        {
            ans = stack.pop()+ans;
        }
        return ans;
    }
}