public class Solution {
    public int coinchange2(ArrayList<Integer> A, int N) {
        // Approach-1: Recursive
        // return helper(A, 0, N);
        
        // Approach-2: DP

        int[][] storage = new int[A.size()+1][N+1];

        for(int i=0; i<storage.length; i++){
            storage[i][0] = 1;
        }
        for(int j=1; j<storage[0].length; j++){
            storage[0][j] = 0;
        }
        for(int i=1; i<storage.length; i++){
            for(int j=1; j<storage[i].length; j++){
                int sa1 = 0;
                if(j-A.get(i-1) >= 0)
                    sa1 = storage[i][j-A.get(i-1)];
                int sa2 = storage[i-1][j];
                storage[i][j] = (sa1%1000007 + sa2%1000007)%1000007;
            }
        }
        return (storage[A.size()][N]%1000007);
    }

    // static int helper(ArrayList<Integer> A, int start, int N){
    //     if(N == 0)
    //         return 1;
    //     if(N < 0)
    //         return 0;
    //     if(start == A.size())
    //         return 0;
    //     int sa1 = helper(A, start, N - A.get(start));
    //     int sa2 = helper(A, start+1, N);
    //     return (sa1 + sa2);
    // }
}
