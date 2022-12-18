class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<size;i++)
        {
            while(!stack.empty()&&temperatures[i]>temperatures[stack.peek()])
            {   
                res[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}