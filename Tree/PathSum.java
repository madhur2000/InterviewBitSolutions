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
    public int hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null && root.val == sum)
            return 1;
        if(root.left == null && root.right == null)
            return 0;
        int leftAns = hasPathSum(root.left, sum-root.val);
        int rightAns = hasPathSum(root.right, sum-root.val);

        return (leftAns == 1 || rightAns == 1) ? 1 : 0;
    }
}
