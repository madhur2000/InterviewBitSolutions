/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
// Approach-1:

        // Queue<TreeLinkNode> q = new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()){
        //     int n = q.size();
        //     for(int i=1; i<=n; i++){
        //         TreeLinkNode node = q.remove();
        //         if(i == n){
        //             node.next = null;
        //         } else{
        //             node.next = q.peek();
        //         }
        //         if(node.left != null)
        //             q.add(node.left);
        //         if(node.right != null)
        //             q.add(node.right);
        //     }
        // }

// Approach-2:

        if(root == null)
            return;
        
        TreeLinkNode head = root;
        while(head != null){
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode temp = dummy;
            while(head != null){
                if(head.left != null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right != null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }

    }
}
