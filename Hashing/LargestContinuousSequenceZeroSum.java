public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        
        // Approach-1: gives TLE

        // int[] storage = new int[A.size()];
        // storage[0] = A.get(0);

        // for(int i=1; i<A.size(); i++){
        //     storage[i] = storage[i-1] + A.get(i);
        // }

        // int start = 0;
        // int end = -1;

        // int maxLength = 0;
        // for(int i=storage.length-1; i>=0; i--){
        //     if(storage[i] == 0 && maxLength <= (i+1)){
        //         start = 0;
        //         end = i;
        //         maxLength = i+1;
        //         continue;
        //     }
        //     for(int j=0; j<i; j++){
        //         if(storage[j] == storage[i] && maxLength <= (i-j)){
        //             // maxLength = Math.max(maxLength, j-i);
        //             maxLength = i-j;
        //             start = j+1;
        //             end = i;
        //             // break;
        //         }
        //     }
        // }

        // ArrayList<Integer> ans = new ArrayList<>();

        // for(int i=start; i<=end; i++){
        //     ans.add(A.get(i));
        // }

        // return ans;

        // Approach-2:

        // Map<Integer, Integer> map = new HashMap<>();
        // int currSum = 0;
        // int start = 0;
        // int end = -1;
        // for(int i=0; i<A.size(); i++){
        //     currSum += A.get(i);
        //     if(currSum == 0){
        //         int currLength = end - start + 1;
        //         int newLength = i + 1;
        //         if(newLength > currLength){
        //             start = 0;
        //             end = i;
        //         }
        //     }
        //     if(!map.containsKey(currSum)){
        //         map.put(currSum, i);
        //     } else{
        //         // start = map.get(currSum) + 1;
        //         // end = i;
        //         // break;
        //         int currLength = end - start + 1;
        //         int newLength = i - (map.get(currSum)+1);
        //         if(newLength >= currLength){
        //             start = map.get(currSum)+1;
        //             end = i;
        //         }
        //     }
        // }
        // if(end == -1){
        //     return new ArrayList<>();
        // }
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(int i=start; i<=end; i++){
        //     ans.add(A.get(i));
        // }
        // return ans;

        // Revision of Approach-2 | easy to understand

        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = -1;
        int sum = 0;
        int maxLength = 0;
        for(int i=0; i<A.size(); i++){
            sum += A.get(i);
            if(sum == 0 && maxLength < (i+1)){
                maxLength = i+1;
                start = 0;
                end = i;
                continue;
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            } else{
                if(maxLength < (i - map.get(sum))){
                    maxLength = i - map.get(sum);
                    start = map.get(sum) + 1;
                    end = i;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=start; i<=end; i++){
            ans.add(A.get(i));
        }
        return ans;
    }
}
