/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> A) {
        return helper(A, 0, A.size()-1);
    }
    static TreeNode helper(ArrayList<Integer> A, int start, int end){
        if(start > end)
            return null;
        int maxIndex = getMaxElementIndex(A, start, end);
        TreeNode root = new TreeNode(A.get(maxIndex));
        TreeNode leftSubtree = helper(A, start, maxIndex-1);
        TreeNode rightSubtree = helper(A, maxIndex+1, end);
        root.left = leftSubtree;
        root.right = rightSubtree;
        return root;
    }
    static int getMaxElementIndex(ArrayList<Integer> A, int start, int end){
        int maxElement = Integer.MIN_VALUE;
        int maxElementIndex = -1;
        for(int i=start; i<=end; i++){
            if(A.get(i) > maxElement){
                maxElement = A.get(i);
                maxElementIndex = i;
            }
        }
        return maxElementIndex;
    }
}
