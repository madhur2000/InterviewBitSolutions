public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(A == 0) return ans;
        ans.add(new ArrayList<>(Arrays.asList(1)));
        if(A == 1)
            return ans;
        ans.add(new ArrayList<>(Arrays.asList(1, 1)));
        for(int i=3; i<=A; i++){
            ArrayList<Integer> list = ans.get(ans.size()-1);
            ArrayList<Integer> currList = new ArrayList<>();
            currList.add(1);
            for(int j=1; j<list.size(); j++){
                currList.add(list.get(j) + list.get(j-1));
            }
            currList.add(1);
            ans.add(currList);
        }
        return ans;
    }
}
