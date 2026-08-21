class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') leftStack.push(i);
            else if(s.charAt(i)=='*') starStack.push(i);
            else{
                if(!leftStack.isEmpty()) leftStack.pop();
                else if(!starStack.isEmpty()) starStack.pop();
                else{
                    return false;
                }
            }
        }
        while(!leftStack.isEmpty() && !starStack.isEmpty()){
            if(leftStack.peek()<starStack.peek())
{               leftStack.pop();
                starStack.pop();         

            }
            else{
                return false;
            }
        }
        return leftStack.isEmpty();
    }
}
