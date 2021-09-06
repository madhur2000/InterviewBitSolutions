public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        // return helper(A, A.size()-1, B);


        // DP:
        boolean[][] storage = new boolean[A.size()+1][B+1];
        int m = storage.length;
        int n = storage[0].length;
        storage[0][0] = true;
        for(int i=1; i<n; i++){
            storage[0][i] = false;
        }
        for(int i=1; i<m; i++){
            storage[i][0] = true;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){

                if(j-A.get(i-1) < 0){
                    storage[i][j] = storage[i-1][j];
                    continue;
                }

                storage[i][j] = (storage[i-1][j] || storage[i-1][j-A.get(i-1)]);
            }
        }

        return storage[m-1][n-1] ? 1 : 0;
    }

    public static int helper(ArrayList<Integer> A, int end, int B){
        if(end < 0 && B == 0)
            return 1;
        if(end < 0)
            return 0;
        if(B == 0)
            return 1;
        
        boolean ans = (helper(A, end-1, B) == 1 || helper(A, end-1, B-A.get(end)) == 1);
        return (ans ? 1 : 0);
    }
}
