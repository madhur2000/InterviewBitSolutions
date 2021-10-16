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
    public int lca(TreeNode root, int v, int w) {
        if(!search(root, v) || !search(root, w))
            return -1;
        return lcaHelper(root, v, w).val;
    }

    static TreeNode lcaHelper(TreeNode root, int v, int w){
        if(root == null)
            return null;
        if(root.val == v || root.val == w) 
            return root;

        TreeNode leftAns = lcaHelper(root.left, v, w);
        TreeNode rightAns = lcaHelper(root.right, v, w);

        if(leftAns == null) return rightAns;

        if(rightAns == null) return leftAns;

        return root;
    }

    static boolean search(TreeNode root, int data){
        if(root == null)
            return false;
        if(root.val == data)
            return true;
        return (search(root.left, data) || search(root.right, data));
    }
}
