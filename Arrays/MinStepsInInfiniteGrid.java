public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = 0;
        int n = A.size();
        for(int i=1; i<n; i++){
            int x1 = A.get(i-1);
            int x2 = A.get(i);
            int y1 = B.get(i-1);
            int y2 = B.get(i);
            ans += Math.max(Math.abs(x2-x1), Math.abs(y2-y1));
        }
        return ans;
    }
}
