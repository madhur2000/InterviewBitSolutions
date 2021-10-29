public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int start = 0;
        int end = -1;
        for(int i=0; i<A.size(); i++){
            currSum += A.get(i);
            if(currSum == 0){
                int currLength = end - start + 1;
                int newLength = i + 1;
                if(newLength > currLength){
                    start = 0;
                    end = i;
                }
            }
            if(!map.containsKey(currSum)){
                map.put(currSum, i);
            } else{
                // start = map.get(currSum) + 1;
                // end = i;
                // break;
                int currLength = end - start + 1;
                int newLength = i - (map.get(currSum)+1);
                if(newLength >= currLength){
                    start = map.get(currSum)+1;
                    end = i;
                }
            }
        }
        if(end == -1){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=start; i<=end; i++){
            ans.add(A.get(i));
        }
        return ans;
    }
}
