public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        // Approach-1: O(NlogN) | Accepted | Better approach for this question
        // Collections.sort(A);
        // for(int i=1; i<A.size(); i+=2){
        //     swap(A, i, i-1);
        // }
        // return A;



        // Approach-2: O(NlogN)
        Collections.sort(A);
        for(int i=1; i<A.size(); i+=2){
            if(A.get(i-1) < A.get(i)){
                swap(A, i-1, i);
            }
            if((i+1) < A.size() && A.get(i) > A.get(i+1)){
                swap(A, i, i+1);
            }
        }
        return A;
    }
    static void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
