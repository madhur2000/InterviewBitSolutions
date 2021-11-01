public class Solution {
    public int minDistance(String A, String B) {
        // if(A.length() == 0)
        //     return B.length();
        // if(B.length() == 0)
        //     return A.length();

        // int min = Integer.MAX_VALUE;
        // if(A.charAt(0) == B.charAt(0))
        //     return minDistance(A.substring(1), B.substring(1));
        // int sa1 = 1 + minDistance(A.substring(1), B);   //delete
        // int sa2 = 1 + minDistance(A, B.substring(1));   //insert
        // int sa3 = 1 + minDistance(A.substring(1), B.substring(1));  //replace

        // return Math.min(sa1, Math.min(sa2, sa3));

        int[][] storage = new int[A.length()+1][B.length()+1];
        
        for(int i=0; i<=A.length(); i++){
            for(int j=0; j<=B.length(); j++){
                if(i == 0){
                    storage[i][j] = j;
                    continue;
                }
                if(j == 0){
                    storage[i][j] = i;
                    continue;
                }
                if(A.charAt(i-1) == B.charAt(j-1)){
                    storage[i][j] = storage[i-1][j-1];
                    continue;
                }
                storage[i][j] = 1 + Math.min(storage[i-1][j], 
                                    Math.min(storage[i][j-1], storage[i-1][j-1]));
            }
        }
        return storage[A.length()][B.length()];
    }
}
