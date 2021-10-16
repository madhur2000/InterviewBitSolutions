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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isOdd = true;
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> currLevel = new ArrayList<>();
            while(n-- > 0){
                TreeNode node = q.remove();
                currLevel.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            if(isOdd){
                ans.add(currLevel);
                isOdd = !isOdd;
            } else{
                Collections.reverse(currLevel);
                ans.add(currLevel);
                isOdd = !isOdd;
            }
        }
        return ans;
    }
}
