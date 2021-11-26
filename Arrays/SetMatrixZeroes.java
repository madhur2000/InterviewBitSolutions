public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        // Approach-1:
        // Set<Integer> row_set = new HashSet<>();
        // Set<Integer> col_set = new HashSet<>();
        // for(int i=0; i<a.size(); i++){
        //     for(int j=0; j<a.get(i).size(); j++){
        //         if((int)a.get(i).get(j) == 0){
        //             row_set.add(i);
        //             col_set.add(j);
        //         }
        //     }
        // }
        // for(int i=0; i<a.size(); i++){
        //     for(int j=0; j<a.get(i).size(); j++){
        //         if(row_set.contains(i) || col_set.contains(j)){
        //             a.get(i).set(j, 0);
        //         }
        //     }
        // }


        // Approach-2:
        boolean[] row = new boolean[a.size()];
        boolean[] col = new boolean[a.get(0).size()];
        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(i).size(); j++){
                if((int)a.get(i).get(j) == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(i).size(); j++){
                if(row[i] || col[j])
                    a.get(i).set(j, 0);
            }
        }
	}
}
