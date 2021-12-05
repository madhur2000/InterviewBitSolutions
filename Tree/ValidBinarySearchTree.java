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
 class Triplet{
     int largest;
     int smallest;
     boolean isBST;
 }
public class Solution {
    public int isValidBST(TreeNode root) {
        return (helper(root).isBST ? 1 : 0);
    }
    static Triplet helper(TreeNode root){
        if(root == null){
            Triplet ans = new Triplet();
            ans.largest = Integer.MIN_VALUE;
            ans.smallest = Integer.MAX_VALUE;
            ans.isBST = true;
            return ans;
        }
        Triplet leftAns = helper(root.left);
        Triplet rightAns = helper(root.right);
        if(leftAns.largest < root.val && root.val < rightAns.smallest
            && leftAns.isBST && rightAns.isBST){
                Triplet ans = new Triplet();
                ans.largest = Math.max(root.val, rightAns.largest);
                ans.smallest = Math.min(root.val, leftAns.smallest);
                ans.isBST = true;
                return ans;
            }
            Triplet ans = new Triplet();
            ans.largest = Math.max(root.val, rightAns.largest);
            ans.smallest = Math.min(root.val, leftAns.smallest);
            ans.isBST = false;
            return ans;
    }
}
