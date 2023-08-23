class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        int val = 0;
        while(!stack1.isEmpty())
        {
            val = stack1.pop();
            stack2.push(val);
        }
        stack2.pop();
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

        return val;
    }
    
    public int peek() {
        int val = 0;
        while(!stack1.isEmpty())
        {

            val = stack1.peek();
            stack2.push(stack1.pop());
        }
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

        return val;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */