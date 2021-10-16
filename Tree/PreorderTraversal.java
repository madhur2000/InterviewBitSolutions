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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else{
                TreeNode node  = stack.pop();
                curr = node.right;
            }
        }
        return ans;
    }
}
