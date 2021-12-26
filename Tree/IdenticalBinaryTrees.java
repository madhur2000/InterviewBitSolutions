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
    public int isSameTree(TreeNode root1, TreeNode root2) {
        if((root1 == null && root2 != null) || 
            (root1 != null && root2 == null)) return 0;
        if(root1 == null && root2 == null) return 1;
        if(root1.val != root2.val) return 0;

        int leftIsIdentical = isSameTree(root1.left, root2.left);
        int rightIsIdentical = isSameTree(root1.right, root2.right);
        if(leftIsIdentical == 1 && rightIsIdentical == 1) return 1;
        return 0;
    }
}
