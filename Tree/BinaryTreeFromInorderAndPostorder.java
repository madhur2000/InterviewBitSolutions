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
    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        return helper(inorder, postorder, 0, inorder.size()-1, 0, postorder.size()-1);
    }

    static TreeNode helper(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd)
            return null;
        int rootVal = postorder.get(postEnd);
        int index = -1;
        for(int i=inStart; i<=inEnd; i++){
            if(inorder.get(i) == rootVal){
                index = i;
                break;
            }
        }
        int dist = index - inStart;
        TreeNode leftSubtree = helper(inorder, postorder, inStart, index-1, postStart, postStart+dist-1);
        TreeNode rightSubtree = helper(inorder, postorder, index+1, inEnd, postStart+dist, postEnd-1);

        TreeNode root = new TreeNode(rootVal);
        root.left = leftSubtree;
        root.right = rightSubtree;
        return root;
    }
}
