class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    //int min=Integer.MIN_VALUE;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty())
            minStack.push(val);
        else if(val<=minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        int x = stack.pop();
        if(x==minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
