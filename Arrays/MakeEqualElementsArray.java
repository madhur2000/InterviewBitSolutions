public class Solution {
    public int solve(ArrayList<Integer> A, int x) {
        // Approach-1: Brute force | TLE
        // for(int i=0; i<A.size(); i++){
        //     ArrayList<Integer> B = new ArrayList<>(A);
        //     int fixed = B.get(i);
        //     int j=0;
        //     for(; j<B.size(); j++){
        //         if(B.get(j) < fixed){
        //             B.set(j, B.get(j)+x);
        //         } else if(B.get(j) > fixed){
        //             B.set(j, B.get(j)-x);
        //         }
        //         if(B.get(j) != fixed){
        //             break;
        //         }
        //     }
        //     if(j == B.size()) return 1;
        // }
        // return 0;



        // Approach-2:
        Collections.sort(A);
        if(A.get(0).equals(A.get(A.size()-1))){
            return 1;
        }
        int same = A.get(0) + x;

        for(int i=1; i<A.size(); i++){
            if(A.get(i) != same && A.get(i)+x != same && A.get(i)-x != same){
                return 0;
            }
        }
        return 1;
    }
}
