class MyStack {
    Queue<Integer> queue;
    int size = 0;
    public MyStack() {
        queue = new LinkedList<>();
    }
    // 1
    // 2,1-> 1,2
    // 3,1,2->1,2,3
    public void push(int x) {
        queue.add(x);
        int tmp = size;
        while(tmp>0)
        {
            queue.add(queue.poll());
            tmp--;
        }
        size++;
    }
    
    public int pop() {
      return queue.poll();
    }
    
    public int top() {
      return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
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