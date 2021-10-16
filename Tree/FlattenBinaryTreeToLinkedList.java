/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeNode flatten(TreeNode root) {
		if(root == null)
			return null;
		TreeNode leftLinkedList = flatten(root.left);
		TreeNode rightLinkedList = flatten(root.right);
		root.left = null;
		root.right = leftLinkedList;
		TreeNode temp = root;
		
		while(temp.right != null){
			temp = temp.right;
		}
		temp.right = rightLinkedList;
		return root;
	}
}
