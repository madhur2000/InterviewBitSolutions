public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        int n = A.size();

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            while(!stack.empty() && stack.peek() >= A.get(i)){
                stack.pop();
            }
            if(stack.empty()){
                ans.add(-1);
            } else{
                ans.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        return ans;
    }
}
