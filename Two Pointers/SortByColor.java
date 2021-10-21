public class Solution {
	public void sortColors(ArrayList<Integer> a) {

// Approach-1: Using Map

		// Map<Integer, Integer> counts = new HashMap<>();
		// for(Integer i : a){
		// 	counts.put(i, counts.getOrDefault(i, 0)+1);
		// }
		// int red_count = 0;
		// int white_count = 0;
		// int blue_count = 0;
		// if(counts.containsKey(0))
		// 	red_count = counts.get(0);
		// if(counts.containsKey(1))
		// 	white_count = counts.get(1);
		// if(counts.containsKey(2))
		// 	blue_count = counts.get(2);
		// int index = 0;
		// for(int i=0; i<red_count; i++){
		// 	a.set(index++, 0);
		// }
		// for(int i=0; i<white_count; i++){
		// 	a.set(index++, 1);
		// }
		// for(int i=0; i<blue_count; i++){
		// 	a.set(index++, 2);
		// }

// Approach-2: Same approach Without Map

		int red_count = 0;
		int white_count = 0;
		int blue_count = 0;

		for(Integer i : a){
			if(i == 0){
				red_count++;
			}
			else if(i == 1)
				white_count++;
			else blue_count++;
		}

		int index = 0;
		for(int i=0; i<red_count; i++){
			a.set(index++, 0);
		}
		for(int i=0; i<white_count; i++){
			a.set(index++, 1);
		}
		for(int i=0; i<blue_count; i++){
			a.set(index++, 2);
		}

	}
}
