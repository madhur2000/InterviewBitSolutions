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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null)
                stack1.push(node.left);
            if(node.right != null)
                stack1.push(node.right);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack2.isEmpty()){
            ans.add(stack2.pop().val);
        }
        return ans;
    }
}
