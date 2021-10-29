/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;
        RandomListNode head2 = new RandomListNode(0);
        RandomListNode temp2 = head2;
        while(temp != null){
            temp2.next = new RandomListNode(temp.label);
            map.put(temp, temp2.next);
            temp = temp.next;
            temp2 = temp2.next;
        }
        temp = head;
        while(temp != null){
            RandomListNode random = map.get(temp.random);
            RandomListNode node = map.get(temp);
            node.random = random;
            temp = temp.next;
        }
        return head2.next;
    }
}
