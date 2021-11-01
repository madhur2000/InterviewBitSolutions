public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> A) {

// Approach-1:

        // int n = A.size();
        // int maxArea = Integer.MIN_VALUE;
        // int[][] storage = new int[n][n];
        // for(int i=0; i<n; i++){
        //     for(int j=i; j<n; j++){
        //         if(i == j){
        //             storage[i][j] = A.get(j);
        //         } else{
        //             storage[i][j] = A.get(j) * storage[i][j-1];
        //         }
        //         maxArea = Math.max(maxArea, storage[i][j]);
        //     }
        // }
        // return maxArea;

// Approach-2:

        int currProduct = 1;
        int n = A.size();
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            currProduct = currProduct * A.get(i);
            ans = Math.max(ans, currProduct);
            if(currProduct == 0){
                currProduct = 1;
            }
        }
        currProduct = 1;
        for(int i=n-1; i>=0; i--){
            currProduct = currProduct * A.get(i);
            ans = Math.max(ans, currProduct);
            if(currProduct == 0){
                currProduct = 1;
            }
        }
        return ans;
    }
    
}
