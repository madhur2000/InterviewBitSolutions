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
    public int kthsmallest(TreeNode root, int k) {
        List<Integer> inorder = getInorder(root);
        return inorder.get(k-1);
    }
    static List<Integer> getInorder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        List<Integer> leftAns = getInorder(root.left);
        ans.addAll(leftAns);
        ans.add(root.val);
        List<Integer> rightAns = getInorder(root.right);
        ans.addAll(rightAns);
        return ans;
    }
}
