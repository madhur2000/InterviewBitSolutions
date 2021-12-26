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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if(leftMinDepth < rightMinDepth && leftMinDepth != 0){
            return (leftMinDepth + 1);
        }
        if(leftMinDepth == 0)
            return (rightMinDepth + 1);
        if(rightMinDepth != 0)
            return (rightMinDepth + 1);
        return (leftMinDepth + 1);
    }
}
