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
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.size()-1, 0, inorder.size()-1);
    }

    static TreeNode buildTreeHelper(ArrayList<Integer> preorder, ArrayList<Integer> inorder, 
                                    int prestart, int preend, int instart, int inend){
        if(prestart > preend || instart > inend) 
            return null;
        int rootVal = preorder.get(prestart);
        int rootIndex = -1;
        for(int i=instart; i<=inend; i++){
            if(inorder.get(i) == rootVal){
                rootIndex = i;
                break;
            }
        }
        int dist = rootIndex - instart;
        TreeNode leftSubtree = buildTreeHelper(preorder, inorder, prestart+1, prestart+dist, instart, rootIndex-1);
        TreeNode rightSubtree = buildTreeHelper(preorder, inorder, prestart+dist+1, preend, rootIndex+1, inend);

        TreeNode root = new TreeNode(rootVal);
        root.left = leftSubtree;
        root.right = rightSubtree;
        return root;
    }
}
