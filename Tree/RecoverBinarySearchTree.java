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
    public ArrayList<Integer> recoverTree(TreeNode root) {

        ArrayList<Integer> inorder = getInorder(root);

        int a = -1;
        int b = -1;
        int i=1;
        for(; i<inorder.size(); i++){
            if(inorder.get(i) < inorder.get(i-1)){
                a = inorder.get(i-1);
                b = inorder.get(i);
                i++;
                break;
            }
        }

        while(i < inorder.size()){
            if(inorder.get(i) < inorder.get(i-1)){
                b = inorder.get(i);
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if(a < b){
            ans.add(a);
            ans.add(b);
            return ans;
        }

        ans.add(b);
        ans.add(a);
        return ans;
    }
    static ArrayList<Integer> getInorder(TreeNode root){
        if(root == null)
            return new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(getInorder(root.left));
        ans.add(root.val);
        ans.addAll(getInorder(root.right));
        return ans;
    }
}
