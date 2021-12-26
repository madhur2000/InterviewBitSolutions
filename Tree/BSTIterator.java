/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {


// Approach-1: time: O(1) | space: O(N)

    // TreeNode itr;
    // ArrayList<Integer> reverseInorder;

    // public Solution(TreeNode root) {
    //     itr = root;
    //     reverseInorder = getReverseInorder(root);
    // }

    // /** @return whether we have a next smallest number */
    // public boolean hasNext() {
    //     if(reverseInorder.size() == 0)
    //         return false;
    //     return true;
    // }

    // /** @return the next smallest number */
    // public int next() {
    //     int smallest = reverseInorder.get(reverseInorder.size()-1);
    //     reverseInorder.remove(reverseInorder.size()-1);
    //     return smallest;
    // }

    // private ArrayList<Integer> getReverseInorder(TreeNode root){
    //     if(root == null)
    //         return new ArrayList<>();
    //     ArrayList<Integer> rightInorder = getReverseInorder(root.right);
    //     ArrayList<Integer> leftInorder = getReverseInorder(root.left);
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     ans.addAll(rightInorder);
    //     ans.add(root.val);
    //     ans.addAll(leftInorder);
    //     return ans;
    // }





    // Approach-2: time: theta(1) | space: O(H)

    Stack<TreeNode> stack;
    TreeNode itr;

    public Solution(TreeNode root) {
        stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        itr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.empty()) return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode poppedNode = stack.pop();
        int smallest = poppedNode.val;
        TreeNode t = poppedNode.right;
        while(t != null){
            stack.push(t);
            t = t.left;
        }
        return smallest;
    }

}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
