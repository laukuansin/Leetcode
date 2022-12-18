class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i=size-1;i>=0;i--)
        {
            int count = 1;
            while(!stack.empty()&&temperatures[i]>=stack.peek().getKey())
            {   
                count+=stack.peek().getValue();
                stack.pop();
            }
            if(stack.empty())
            {
                res[i] = 0;
                stack.push(new Pair<>(temperatures[i],0));
            }
            else{
                res[i] = count;
                stack.push(new Pair<>(temperatures[i],count));
            }
        }
        return res;
    }
}