public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        String currString = "";
        helper(n, n, ans, currString);
        return ans;
    }
    static void helper(int openCount, int closeCount, ArrayList<String> ans, String currString){
        if(closeCount == 0){
            ans.add(new String(currString));
            return;
        }
        if(openCount == 0){
            helper(openCount, closeCount-1, ans, currString+")");
            return;
        }
        if(openCount == closeCount){
            helper(openCount-1, closeCount, ans, currString+"(");
            return;
        }
        helper(openCount-1, closeCount, ans, currString+"(");
        helper(openCount, closeCount-1, ans, currString+")");
    }
}
