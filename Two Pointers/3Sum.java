public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int target) {
        Collections.sort(A);
        int res = A.get(0) + A.get(1) + A.get(A.size()-1);
        for(int i=0; i<A.size(); i++){
            int j = i+1;
            int k = A.size()-1;
            while(j < k){
                int sum = A.get(i) + A.get(j) + A.get(k);
                if(sum < target){
                    j++;
                } else if(sum > target){
                    k--;
                } else{
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
