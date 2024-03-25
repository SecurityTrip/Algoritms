public class SolutionTwo {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode current = head;

        // First pass: make copies of each node and link them next to the original node
        while (current != null) {
            RandomListNode copy = new RandomListNode(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Second pass: assign random pointers for the copy nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Third pass: separate the original and copy lists
        current = head;
        RandomListNode newHead = head.next;
        RandomListNode newCurrent = newHead;

        while (current != null) {
            current.next = newCurrent.next;
            current = current.next;
            if (current != null) {
                newCurrent.next = current.next;
                newCurrent = newCurrent.next;
            }
        }

        return newHead;
    }
}
