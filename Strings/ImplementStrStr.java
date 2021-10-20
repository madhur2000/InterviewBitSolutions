public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        if(B.length() == 0)
            return -1;
        
        int i=0;
        int j=B.length()-1;
        while(j < A.length()){
            String sub = A.substring(i, j+1);
            if(sub.equals(B))
                return i;
            i++;
            j++;
        }
        return -1;
    }
}
