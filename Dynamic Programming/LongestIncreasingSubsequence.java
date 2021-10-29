public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        // return helper(A, 0, A, 0);

        int[] lengths = new int[A.size()];
        Arrays.fill(lengths, 1);
        lengths[0] = 1;
        for(int i=1; i<lengths.length; i++){
            for(int j=i-1; j>=0; j--){
                if(A.get(j) < A.get(i)){
                    lengths[i] = Math.max(lengths[j]+1, lengths[i]);
                }
            }
        }
        int max = 1;
        for(int i=0; i<lengths.length; i++){
            max = Math.max(max, lengths[i]);
        }
        return max;
    }

    // static int helper(List<Integer> A, int start1, List<Integer> B, int start2){
    //     // if(A.size() == 1)
    //     //     return 1;
        
    //     if(start1 > A.size())
    //         return Integer.MIN_VALUE;
    //     int ans = 1;
    //     for(int i=start1; i<A.size(); i++){
    //         for(int j=i+1; j<A.size(); j++){
    //             if(A.get(i) < B.get(j)){
    //                 int newLength = helper(A, i+1, B, j+1);
    //                 ans = Math.max(ans, newLength+2);
    //             }
    //         }
    //     }
    //     return ans;
    // }
}
