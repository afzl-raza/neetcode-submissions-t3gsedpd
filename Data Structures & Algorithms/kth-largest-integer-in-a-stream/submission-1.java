class KthLargest {
    int k;
    int size;
    int[] heap; 
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.size = 0;
        this.heap = new int[k];
        for(int num : nums){
            add(num);
        }    
    }
    
    public int add(int val) {
        if(size<k){
            heap[size] = val;
            heapifyUp(size);
            size++;
        }
        else if(val > heap[0]){
            heap[0] = val;
            heapifyDown(0);
            }
        return heap[0];
    }
    void pop(){
        // int root = heap[0];
        heap[0] = heap[size-1];
        size--;
        // heap[size-1] = root;
        heapifyDown(0);

    }
    void heapifyUp(int i) { 
        // your code 
        int parent = (i-1)/2; 
        if (i==0 || heap[parent]<=heap[i]) return; 
        int temp = heap[parent]; 
        heap[parent] = heap[i]; 
        heap[i] = temp; 
        heapifyUp(parent); 
    }
    void heapifyDown(int i) { // your code 
        int c1 = 2*i+1; 
        while(c1< size){ 
            int min; int left = c1; 
            int right = 2*i+2; 
            if(right>=size) min = left; 
            else{ min = (heap[left]<=heap[right]) ?left:right; } 
            if(heap[i]<=heap[min]) break; 
            int temp = heap[i]; 
            heap[i] = heap[min]; 
            heap[min] = temp; i = min; 
            c1 = 2*i+1; 
        }
    }
    
}
