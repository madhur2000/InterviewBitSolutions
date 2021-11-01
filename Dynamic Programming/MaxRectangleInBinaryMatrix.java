public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        // return helper(A, 0, A.size()-1, 0, A.get(0).size()-1);
        int maxLength = 0;
        int[][] heights = new int[A.size()][A.get(0).size()];
        for(int i=0; i<A.get(0).size(); i++){
            heights[0][i] = A.get(0).get(i);
        }
        for(int i=1; i<A.size(); i++){
            for(int j=0; j<A.get(i).size(); j++){
                if(A.get(i).get(j) != 0){
                    heights[i][j] = heights[i-1][j] + 1;
                }
            }
        }
        for(int i=0; i<heights.length; i++){
            int currLength = maxRectangleHistogram(heights[i]);
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }

    static int maxRectangleHistogram(int[] heights){
        int[] prevSmallerArr = prevSmaller(heights);
        int[] nextSmallerArr = nextSmaller(heights);
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i<n; i++){
            int height = heights[i];
            int width = nextSmallerArr[i] - prevSmallerArr[i] - 1;
            maxArea = Math.max(maxArea, height*width);
        }
        return maxArea;
    }

    static int[] prevSmaller(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.empty()){
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    
    static int[] nextSmaller(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        // stack.push(n-1);
        // ans[n-1] = n;
        for(int i=n-1; i>=0; i--){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.empty()){
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    // static int helper(ArrayList<ArrayList<Integer>> A, int rowstart, int rowend, 
    //                     int colstart, int colend){
    //     if(rowstart > rowend || colstart > colend){
    //         return 0;
    //     }
    //     if(allAreZeroes(A, rowstart, rowend, colstart, colend)){
    //         return ((rowend+1) * (colend+1));
    //     }
    //     int sa1 = helper(A, rowstart+1, rowend, colstart, colend);
    //     int sa2 = helper(A, rowstart, rowend-1, colstart, colend);
    //     int sa3 = helper(A, rowstart, rowend, colstart+1, colend);
    //     int sa4 = helper(A, rowstart, rowend, colstart, colend-1);

    //     return Math.max(Math.max(sa1, sa2), Math.max(sa3, sa4));
    // }

    // static boolean allAreZeroes(ArrayList<ArrayList<Integer>> A, int rowstart, int rowend, 
    //                         int colstart, int colend){
    //     for(int i=rowstart; i<=rowend; i++){
    //         for(int j=colstart; j<=colend; j++){
    //             if(A.get(i).get(j) == 0){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
}
