public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        // Approach-1: Brute Force
        // int ans = 0;
        // for(int i=0; i<A.size(); i++){
        //     for(int j=i+1; j<A.size(); j++){
        //         ans = Math.max(ans, Math.abs(A.get(i)-A.get(j)) + Math.abs(i-j));
        //     }
        // }
        // return ans;


        // Approach-2:
        int[] a1 = new int[A.size()];
        int[] a2 = new int[A.size()];
        for(int i=0; i<A.size(); i++){
            a1[i] = A.get(i) + i;
        }
        for(int i=0; i<A.size(); i++){
            a2[i] = A.get(i) - i;
        }
        int max1 = getMax(a1);
        int min1 = getMin(a1);
        int max2 = getMax(a2);
        int min2 = getMin(a2);
        int diff1 = max1 - min1;
        int diff2 = max2 - min2;
        return Math.max(diff2, diff1);
    }
    static int getMax(int[] a){
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            ans = Math.max(ans, a[i]);
        }
        return ans;
    }
    static int getMin(int[] a){
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++){
            ans = Math.min(ans, a[i]);
        }
        return ans;
    }
}
