public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        int[] increasingLengths = getLIS(A);
        int[] decreasingLengths = getLDS(A);
        int maxLength = 0;
        int n = A.size();
        for(int i=0; i<n; i++){
            int currLength = increasingLengths[i] + decreasingLengths[i] - 1;
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }

    static int[] getLIS(List<Integer> A){
        int[] storage = new int[A.size()];
        Arrays.fill(storage, 1);

        for(int i=1; i<storage.length; i++){
            for(int j=i-1; j>=0; j--){
                if(A.get(j) < A.get(i)){
                    storage[i] = Math.max(storage[i], storage[j]+1);
                }
            }
        }
        return storage;
    }
    
    static int[] getLDS(List<Integer> A){
        int[] storage = new int[A.size()];
        Arrays.fill(storage, 1);
        for(int i=A.size()-2; i>=0; i--){
            for(int j=i+1; j<A.size(); j++){
                if(A.get(i) > A.get(j)){
                    storage[i] = Math.max(storage[i], storage[j]+1);
                }
            }
        }
        return storage;
    }
}
