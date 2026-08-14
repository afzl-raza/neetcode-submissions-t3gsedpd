class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    int size;

    public MedianFinder() {
        this.left = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        this.right = new PriorityQueue<>((a,b)->Integer.compare(a,b));    
    }
    
    public void addNum(int num) {
        if(left.isEmpty()) left.offer(num);
        else{
            if(left.peek()>=num) left.offer(num);
            else right.offer(num);
        }
        if(left.size()>right.size()+1){
            while(left.size()>right.size()+1){
                right.offer(left.poll());
            }   
        }
        else{
            while(right.size()>left.size()){
                left.offer(right.poll());
            }
        }
        
    }
    public double findMedian() {
        if(left.size()>right.size()) return left.peek();
        else return (double)(left.peek()+right.peek())/2;
    }
}
