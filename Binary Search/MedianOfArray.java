public class Solution {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		if(a.size() > b.size())
			return findMedianSortedArrays(b, a);
		int n1 = a.size();
		int n2 = b.size();
		int low = 0;
		int high = a.size();
		while(low <= high){
			int cut1 = (low + high) >> 1;	//means: (low+high)/2
			int cut2 = (n1 + n2 +1)/2 - cut1;
			int l1 = Integer.MIN_VALUE;
			int l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE;
			int r2 = Integer.MAX_VALUE;
			if(cut1 != 0){
				l1 = a.get(cut1-1);
			}
			if(cut2 != 0){
				l2 = b.get(cut2-1);
			}
			if(cut1 != n1){
				r1 = a.get(cut1);
			}
			if(cut2 != n2){
				r2 = b.get(cut2);
			}
			if(l1 <= r2 && l2 <= r1){
				if((n1+n2)%2 != 0)
					return Math.max(l1, l2);
				return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
			} else if(l1 > r2){
				high = cut1 - 1;
			} else{
				low = cut1 + 1;
			}
		}
		return 0;
	}
}
