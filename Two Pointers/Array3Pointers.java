public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        // Approach-1: O(N^3) | Brute Force
        
        // int ans = 0;
        // for(int i=0; i<A.size(); i++){
        //     for(int j=0; j<B.size(); j++){
        //         for(int k=0; k<C.size(); k++){
        //             int val = Math.max(Math.abs(A.get(i) - B.get(j)), 
        //                                 Math.max(Math.abs(B.get(j) - C.get(k)), 
        //                                 Math.abs(C.get(k) - A.get(i))));
        //             ans = Math.min(ans, val);
        //         }
        //     }
        // }
        // return ans;

        // Approach-2: getting benefitted from the "sorted" arrays

        int i=0;
        int j=0;
        int k=0;

        int ans = Integer.MAX_VALUE;

        while(i < A.size() && j < B.size() && k < C.size()){
            int val = Math.max(Math.abs(A.get(i) - B.get(j)), 
            Math.max(Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i))));
            ans = Math.min(ans, val);
            if(A.get(i) <= B.get(j) && A.get(i) <= C.get(k)){
                i++;
            }
            else if(B.get(j) <= A.get(i) && B.get(j) <= C.get(k)){
                j++;
            }
            else{
                k++;
            }
        }
        return ans;
    }
}
