public class Solution {
    public String solve(String s) {
        StringBuilder ans = new StringBuilder();
        s = s.trim();
        int start = s.length()-1;
        int end = s.length()-1;
        while(start >= 0){
            if(s.charAt(start) != ' '){
                start--;
            }
            else{
                ans.append(s.substring(start+1, end+1));
                ans.append(" ");
                while(s.charAt(start) == ' '){
                    start--;
                }
                end = start;
            }
        }
        ans.append(s.substring(start+1, end+1));
        // ans.trim();
        return ans.toString().trim();
    }
}
