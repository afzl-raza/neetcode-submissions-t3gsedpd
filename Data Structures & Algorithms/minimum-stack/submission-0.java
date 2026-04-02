class MinStack {
    Deque<Integer> deq;
    Deque<Integer> min;
    public MinStack() {
        this.deq = new ArrayDeque<>();
        this.min = new ArrayDeque<>();
        
    }
    public void push(int val) {
        deq.offerLast(val);
        if (min.isEmpty()){
            min.offerLast(val);
        }else if( min.peekLast()>=val){
            min.offerLast(val);
        }   
    }
    public void pop() {
        int last = deq.pollLast();
        if (!min.isEmpty()&& last==min.peekLast()){
            min.pollLast();
        }    
    }
    
    public int top() {
        return deq.peekLast();
        
    }
    public int getMin() {
        return min.peekLast();    
    }
}
