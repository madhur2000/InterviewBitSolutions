public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int target) {
        // if(A.get(0) < A.get(A.size()-1)){
        //     return binarySearch(A, 0, A.size()-1, target);
        // }
        int start = 0;
        int end = A.size()-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(A.get(mid) > A.get(end)){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        int pi = start;
        
        if(target >= A.get(0) && pi>0 && target <= A.get(pi-1)){
            return binarySearch(A, 0, pi-1, target);
        }
        return binarySearch(A, pi, A.size()-1, target);
    }

    static int binarySearch(List<Integer> A, int start, int end, int target){
        // int start = 0;
        // int end = e;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(A.get(mid) == target){
                return mid;
            }
            else if(A.get(mid) < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}
