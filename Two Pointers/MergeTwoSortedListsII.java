public class Solution {
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int m = a.size();
		int n = b.size();
		for(int i=1; i<=n; i++){
			a.add(0);
		}
		int k = a.size()-1;
		int i = m-1;
		int j = n-1;
		while(i>=0 && j>=0){
			if(a.get(i) > b.get(j)){
				a.set(k, a.get(i));
				k--;
				i--;
			} else{
				a.set(k, b.get(j));
				k--;
				j--;
			}
		}
		while(i>=0){
			a.set(k, a.get(i));
			i--;
			k--;
		}
		while(j>=0){
			a.set(k, b.get(j));
			j--;
			k--;
		}
	}
}
