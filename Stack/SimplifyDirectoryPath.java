public class Solution {
    public String simplifyPath(String s) {
        Deque<String> dq = new ArrayDeque<>();
        // if(s.charAt(s.length()-1) == '/'){
        //     s = s.substring(0, s.length()-1);
        //     System.out.println(s);
        // }
        String[] directories = s.split("/");
        for(String currString : directories){
            if(!dq.isEmpty() && currString.equals("..")){
                dq.removeLast();
            } else if(!currString.equals(".") 
                    && !currString.equals("")
                    && !currString.equals("..")){
                dq.add(currString);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!dq.isEmpty()){
            String str = dq.removeFirst();
            ans.append("/" + str);
        }
        if(ans.toString().length() == 0)
            return "/";
        return ans.toString();
    }
}
