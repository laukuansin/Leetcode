class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        // first -> last
        // 1,2,3,4,5

        queue1 = new LinkedList<>();//3
        queue2 = new LinkedList<>();//2,1
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
        int topVal = -1;
        while(!queue1.isEmpty())
        {
            topVal = queue1.poll();
            queue2.add(topVal);
        }
       
        while(!queue2.isEmpty())
        {
            queue1.add(queue2.poll());
        }
        return topVal;
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