public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String s, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int smallest = 1;
        int greatest = n;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'I'){
                ans.add(smallest++);
            } else{
                ans.add(greatest--);
            }
        }
        ans.add(smallest);
        return ans;
    }
}
