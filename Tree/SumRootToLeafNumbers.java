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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    static int helper(TreeNode root, int currVal){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return ((currVal * 10)%1003 + root.val)%1003;

        currVal = ((currVal * 10)%1003 + root.val)%1003;

        int leftAns = helper(root.left, currVal);
        int rightAns = helper(root.right, currVal);

        return (leftAns + rightAns)%1003;
    }

}
