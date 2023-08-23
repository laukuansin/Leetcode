class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.add(x);
    }
    
    public int pop() {
        while(queue1.size()>1)
        {
            queue2.add(queue1.poll());
        }
        int popVal = queue1.poll();

        while(!queue2.isEmpty())
        {
            queue1.add(queue2.poll());
        }

        return popVal;
    }
    
    public int top() {
        while(queue1.size()>1)
        {
            queue2.add(queue1.poll());
        }
        int peekVal = queue1.poll();
        queue2.add(peekVal);

        while(!queue2.isEmpty())
        {
            queue1.add(queue2.poll());
        }

        return peekVal;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */