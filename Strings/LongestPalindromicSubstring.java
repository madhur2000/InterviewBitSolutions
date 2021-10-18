public class Solution {
    public String longestPalindrome(String A) {
        // Approach-1:

        // if(isPalindrome(A))
        //     return A;
        // String s1 = longestPalindrome(A.substring(0, A.length()-1));
        // String s2 = longestPalindrome(A.substring(1));

        // if(s1.length() > s2.length())
        //     return s1;
        // return s2;

        // Approach-2:
        
        String s = A;
        String ans = "";
        boolean[][] storage = new boolean[s.length()][s.length()];

        for(int i=0; i<storage.length; i++){
            storage[i][i] = true;
            if(ans.length() < 1){
                ans = s.substring(i, i+1);
            }
        }

        for(int i=0; (i+1)<storage.length; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                storage[i][i+1] = true;
                if(ans.length() < 2){
                    ans = s.substring(i, i+2);
                }
                continue;
            }
            storage[i][i+1] = false;
        }

        for(int i=2; i<storage.length; i++){
            for(int j=0; (j+i)<storage.length; j++){
                if(s.charAt(j) == s.charAt(j+i)
                    && storage[j+1][j+i-1]){
                    storage[j][j+i] = true;
                    if(ans.length() < (i+1)){
                        ans = s.substring(j, j+i+1);
                    }
                }
                else
                    storage[j][j+i] = false;
            }
        }
        return ans;
    }

    // static boolean isPalindrome(String s){
    //     int i=0;
    //     int j=s.length()-1;

    //     while(i < j){
    //         if(s.charAt(i) != s.charAt(j))
    //             return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}
