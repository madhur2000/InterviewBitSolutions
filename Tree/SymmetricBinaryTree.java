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
    public int isSymmetric(TreeNode root) {
        return helper(root, root) ? 1 : 0;
    }

    static boolean helper(TreeNode root1, TreeNode root2){
        
        if(root1 == null && root2 == null)
            return true;

        if((root1 == null && root2 != null)
            || (root1 != null && root2 == null))
            return false;
        
        if(root1.val == root2.val
            && helper(root1.left, root2.right) 
            && helper(root1.right, root2.left))
            return true;

        return false;

    }
}
