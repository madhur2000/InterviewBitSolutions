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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

//  Approach-1:
        
        // if(root == null){
        //     // if(sum == 0){
        //     //     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        //     //     ans.add(new ArrayList<>());
        //     //     return ans;
        //     // }
        //     return new ArrayList<>();
        // }
        // if(root.left == null && root.right == null && sum == root.val){
        //     ArrayList<Integer> list = new ArrayList<>();
        //     list.add(root.val);
        //     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        //     ans.add(list);
        //     return ans;
        // }
        // if(root.left == null && root.right == null){
        //     return new ArrayList<>();
        // }

        // ArrayList<ArrayList<Integer>> leftAns = pathSum(root.left, sum - root.val);
        // ArrayList<ArrayList<Integer>> rightAns = pathSum(root.right, sum - root.val);

        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // for(ArrayList<Integer> list : leftAns){
        //     ArrayList<Integer> currList = new ArrayList<>();
        //     currList.add(root.val);
        //     currList.addAll(list);
        //     ans.add(currList);
        // }
        // for(ArrayList<Integer> list : rightAns){
        //     ArrayList<Integer> currList = new ArrayList<>();
        //     currList.add(root.val);
        //     currList.addAll(list);
        //     ans.add(currList);
        // }
        // return ans;

//     Approach-2:

        return helper(root, sum, new ArrayList<>());

    }

    ArrayList<ArrayList<Integer>> helper(TreeNode root, int sum, ArrayList<Integer> currList){
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null && sum == root.val){
            currList.add(root.val);
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(currList));
            currList.remove(currList.size()-1);
            return ans;
        }

        if(root.left == null && root.right == null){
            return new ArrayList<>();
        }

        currList.add(root.val);
        ArrayList<ArrayList<Integer>> leftAns = helper(root.left, sum - root.val, currList);
        ArrayList<ArrayList<Integer>> rightAns = helper(root.right, sum - root.val, currList);

        currList.remove(currList.size()-1);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.addAll(leftAns);
        ans.addAll(rightAns);

        return ans;
    }

}
