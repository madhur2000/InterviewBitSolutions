public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
// Approach-1: Recursion + HashSet

        // Set<ArrayList<Integer>> set = helper(A);
        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // for(ArrayList<Integer> list : set){
        //     ans.add(list);
        // }
        // return ans;

        // Approach-2: Backtracking + HashMap
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.size(); i++){
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0)+1);
        }
        helper(nums, ans, currList, map);
        return ans;
    }
    void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> currList, Map<Integer, Integer> map){
        if(currList.size() == nums.size()){
            ans.add(new ArrayList<>(currList));
            return;
        }
        for(Integer num : map.keySet()){
            if(map.get(num) != 0){
                map.put(num, map.get(num)-1);
                currList.add(num);
                helper(nums, ans, currList, map);
                map.put(num, map.get(num)+1);
                currList.remove(currList.size()-1);
            }
        }
    }
    // static Set<ArrayList<Integer>> helper(ArrayList<Integer> A){
    //     if(A.size() == 1){
    //         Set<ArrayList<Integer>> list1 = new HashSet<>();
    //         ArrayList<Integer> list2 = new ArrayList<>();
    //         list2.add(A.get(0));
    //         list1.add(list2);
    //         return list1;
    //     }
    //     Set<ArrayList<Integer>> ans = new HashSet<>();
    //     for(int i=0; i<A.size(); i++){
    //         ArrayList<Integer> list = new ArrayList<>();
    //         for(int j=0; j<A.size(); j++){
    //             if(j != i){
    //                 list.add(A.get(j));
    //             }
    //         }
    //         Set<ArrayList<Integer>> sa = helper(list);
    //         for(ArrayList<Integer> currList : sa){
    //             ArrayList<Integer> newCurrList = new ArrayList<>();
    //             newCurrList.addAll(currList);
    //             newCurrList.add(A.get(i));
    //             ans.add(newCurrList);
    //         }
    //     }
    //     return ans;
    // }
}
