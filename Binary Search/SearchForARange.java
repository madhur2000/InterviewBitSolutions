public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int start = getStart(A, B);
        int end = getEnd(A, B);
        return new ArrayList<>(Arrays.asList(start, end));
    }

    static int getStart(List<Integer> A, int target){
        int index = -1;
        int start = 0;
        int end = A.size()-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(A.get(mid) == target){
                index = mid;
                end = mid-1;
            }
            else if(A.get(mid) > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return index;
    }

    static int getEnd(List<Integer> A, int target){
        int index = -1;
        int start = 0;
        int end = A.size()-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(A.get(mid) == target){
                index = mid;
                start = mid+1;
            }
            else if(A.get(mid) > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return index;
    }
}
