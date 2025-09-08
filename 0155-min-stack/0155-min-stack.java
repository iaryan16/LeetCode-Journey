class MinStack {
    Stack<Long> s = new Stack<>();
    long min = Integer.MIN_VALUE;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()) {
            s.push((long)val);
            min = val;
        } else {
            if(val > min) {
                s.push((long)val);
            } else {
                s.push(2*(long)val - min);
                min = val;
            }
        }
    }
    
    public void pop() {
        long x = s.peek();
        s.pop();
        if(x < min) {
            min = min * 2 - x;
        }
    }
    
    public long top() {
        if(min < s.peek())
            return s.peek();
        else 
            return min;
    }
    
    public long getMin() {
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */