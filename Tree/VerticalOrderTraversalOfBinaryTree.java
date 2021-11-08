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

class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair removed = q.remove();
            TreeNode currNode = removed.node;
            int currLevel = removed.level;
            if(!map.containsKey(currLevel)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(currNode.val);
                map.put(currLevel, list);
            } else{
                ArrayList<Integer> list = map.get(currLevel);
                list.add(currNode.val);
            }
            if(currNode.left != null){
                q.add(new Pair(currNode.left, currLevel-1));
            }
            if(currNode.right != null){
                q.add(new Pair(currNode.right, currLevel+1));
            }
        }
        for(Integer level : map.keySet()){
            ans.add(map.get(level));
        }
        return ans;
    }
}
