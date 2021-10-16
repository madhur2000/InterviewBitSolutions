public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        List<Integer> leftMax = getLeftMax(A);
        List<Integer> rightMax = getRightMax(A);

        int ans = 0;

        for(int i=0; i<A.size(); i++){
            ans = ans + Math.min(leftMax.get(i), rightMax.get(i)) - A.get(i);
        }
        return ans;
    }

    static List<Integer> getLeftMax(List<Integer> A){
        List<Integer> ans = new ArrayList<>();
        ans.add(A.get(0));
        for(int i=1; i<A.size(); i++){
            ans.add(Math.max(ans.get(i-1), A.get(i)));
        }
        return ans;
    }
    
    static List<Integer> getRightMax(List<Integer> A){
        List<Integer> ans = new ArrayList<>();
        ans.add(A.get(A.size()-1));
        for(int i=A.size()-2; i>=0; i--){
            ans.add(Math.max(A.get(i), ans.get(ans.size()-1)));
        }
        Collections.reverse(ans);
        return ans;

        // int[] ans_arr = new int[A.size()];
        // ans_arr[ans_arr.length-1] = A.get(A.size()-1);
        // for(int i=A.size()-2; i>=0; i--){
        //     ans_arr[i] = Math.max(A.get(i), ans_arr[i+1]);
        // }

        // for(int i=0; i<ans_arr.length; i++){
        //     ans.add(ans_arr[i]);
        // }
        // return ans;
    }
}
