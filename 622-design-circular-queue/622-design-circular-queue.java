class MyCircularQueue {
    int[] array;
    int size;
    int frontIdx;
    int backIdx;
    int CAPACITY;
    
    public MyCircularQueue(int k) {
        array = new int[k];
        size = 0;
        frontIdx = 0;
        backIdx = -1;
        CAPACITY = k;
    }
    
    public boolean enQueue(int value) {
        if(size==CAPACITY)
            return false;
        
        array[++backIdx%CAPACITY]=value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size==0)
            return false;
        ++frontIdx;
        size--;
        return true;
    }
    
    public int Front() {
        if(size==0)
            return -1;
        
        return array[frontIdx%CAPACITY];
    }
    
    public int Rear() {
        if(size==0)
            return -1;
        
        return array[backIdx%CAPACITY];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==CAPACITY;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */