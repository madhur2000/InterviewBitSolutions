public class Solution {
	public int removeDuplicates(ArrayList<Integer> a) {
        // Set<Integer> set = new HashSet<>();
        int k = 0;
        for(int i=0; i<a.size(); i++){
            if(i == 0 || !a.get(i).equals(a.get(i-1))){
                a.set(k, a.get(i));
                k++;
            }
        }
        return k;
	}
}
