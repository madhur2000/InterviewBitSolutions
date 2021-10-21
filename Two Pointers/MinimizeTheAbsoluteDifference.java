public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i=0;
        int j=0;
        int k=0;
        int diff = Integer.MAX_VALUE;
        while(i < A.size() && j < B.size() && k < C.size()){
            int max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            int min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int currDiff = Math.abs(max - min);
            diff = Math.min(diff, currDiff);
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
        return diff;
    }
}
