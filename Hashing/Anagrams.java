public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<A.size(); i++){
            String currString = A.get(i);
            char[] currStringArr = currString.toCharArray();
            Arrays.sort(currStringArr);
            // String currStringSorted = currStringArr.toString();
            String currStringSorted = new String(currStringArr);
            if(!map.containsKey(currStringSorted)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i+1);
                map.put(currStringSorted, list);
            } else{
                ArrayList<Integer> list = map.get(currStringSorted);
                list.add(i+1);
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(String s : map.keySet()){
            ArrayList<Integer> list = map.get(s);
            ans.add(list);
        }
        return ans;
    }
}
