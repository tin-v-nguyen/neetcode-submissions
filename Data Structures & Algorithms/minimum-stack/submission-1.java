class MinStack {
    private Stack<Integer> stack;
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int min = stack.peek();
        while (!stack.isEmpty()) {
            Integer next = stack.pop();
            min = Math.min(min, next);
            tmp.push(next);
        }
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return min;
    }
}
