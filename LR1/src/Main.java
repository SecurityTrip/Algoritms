public class Main {
    public static void main(String[] args) {
        // Тесты для задачи 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = head1.next;

        SolutionOne solution1 = new SolutionOne();
        ListNode result1 = solution1.detectCycle(head1);
        System.out.println("Начальный узел петли: " + result1.val);

        // Тесты для задачи 2
        RandomListNode head2 = new RandomListNode(1);
        head2.next = new RandomListNode(2);
        head2.next.next = new RandomListNode(3);
        head2.random = head2.next.next;
        head2.next.random = head2;
        head2.next.next.random = head2.next;

        SolutionTwo solution2 = new SolutionTwo();
        RandomListNode result2 = solution2.copyRandomList(head2);
        System.out.println("Скопированный список с двумя указателями:");
        while (result2 != null) {
            System.out.println("Value: " + result2.val + ", Random: " + (result2.random != null ? result2.random.val : "null"));
            result2 = result2.next;
        }

        // Тесты для задачи 3
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(2);
        head3.next.next.next = new ListNode(3);
        head3.next.next.next.next = new ListNode(4);
        head3.next.next.next.next.next = new ListNode(4);

        SolutionThree solution3 = new SolutionThree();
        solution3.deleteDuplicates(head3);

        System.out.println("Список после удаления дубликатов:");
        ListNode current = head3;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
