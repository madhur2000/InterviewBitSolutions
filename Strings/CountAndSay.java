public class Solution {
    public String countAndSay(int A) {

        String[] series = new String[A+1];
        series[1] = "1";

        for(int i=2; i<=A; i++){
            String s = series[i-1];
            StringBuilder ans = new StringBuilder();
            for(int j=0; j<s.length(); ){
                char currChar = s.charAt(j);
                int count = 0;
                int k;
                for(k=j; k<s.length(); k++){
                    if(s.charAt(k) == s.charAt(j))
                        count++;
                    else
                        break;
                }
                ans.append(count);
                ans.append(currChar);
                j=k;
            }
            series[i] = ans.toString();
        }
        return series[A];
    }
}
