class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deq = new ArrayDeque<>();
        for ( String c: tokens){
            if (c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-")){
                if(c.equals("*")){
                int f = deq.pollLast();
                int s = deq.pollLast();
                int res = f*s;
                deq.offerLast(res);
                }
                else if (c.equals("+")){
                    int f = deq.pollLast();
                    int s = deq.pollLast();
                    int res = f+s;
                    deq.offerLast(res);
                }
                else if (c.equals("-")){
                    int f = deq.pollLast();
                    int s = deq.pollLast();
                    int res = s-f;
                    deq.offerLast(res);
                }
                else if (c.equals("/")){
                    int f = deq.pollLast();
                    int s = deq.pollLast();
                    int res = s/f;
                    deq.offerLast(res);
                }

            }
            else{
                deq.offerLast(Integer.parseInt(c));
            }

            
        }
        return deq.pollLast();
    }
}
