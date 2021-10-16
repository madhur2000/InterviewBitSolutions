// class Node{
//     int val;
//     Node next;
//     int min;
//     public Node(int val){
//         this.val = val;
//         next = null;
//     }
// }

class Solution {
// Approach-1:

    // Node head = null;
    // public void push(int x) {
    //     if(head == null){
    //         head = new Node(x);
    //         head.min = x;
    //     } else{
    //         Node temp = new Node(x);
    //         temp.min = Math.min(x, head.min);
    //         temp.next = head;
    //         head = temp;
    //     }
    // }

    // public void pop() {
    //     if(head == null)
    //         return;
    //     head = head.next;
    // }

    // public int top() {
    //     if(head == null)
    //         return -1;
    //     return head.val;
    // }

    // public int getMin() {
    //     if(head == null)
    //         return -1;
    //     return head.min;
    // }

    // Approach-2:
    
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        if(stack.empty())
            return;
        int popped = stack.pop();
        if(minStack.peek() == popped)
            minStack.pop();
    }

    public int top() {
        if(stack.empty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if(stack.empty())
            return -1;
        return minStack.peek();
    }

}
