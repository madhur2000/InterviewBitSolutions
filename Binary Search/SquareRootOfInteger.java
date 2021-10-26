public class Solution {
    public int sqrt(int A) {
        long start = 0;
        long end = A;
        long ans = -1;
        while(start <= end){
            long mid = start + (end - start)/2;
            if(mid*mid == A){
                ans = mid;
                break;
            }
            else if(mid*mid < A){
                ans = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return (int)ans;
    }
}
