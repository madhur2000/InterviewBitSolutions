public class Solution {
	public int removeDuplicates(ArrayList<Integer> a) {
		int k = 0;
		int count = 0;
		for(int i=0; i<a.size(); i++){
			if(i == 0){
				a.set(k, a.get(i));
				count=1;
				k++;
				continue;
			}
			if(!a.get(i).equals(a.get(i-1))){
				count=1;
				a.set(k, a.get(i));
				k++;
				continue;
			}
			if(a.get(i).equals(a.get(i-1)) && count < 2){
				count++;
				a.set(k, a.get(i));
				k++;
			}
		}
		return k;
	}
}
