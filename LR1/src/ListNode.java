class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static ListNode findCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Поиск точки встречи в цикле
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Проверка наличия цикла
        if (fast == null || fast.next == null) {
            return null;
        }

        // Поиск начального узла петли
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode copyList(ListNode head) {
        if (head == null) return null;

        // Первый проход: копирование узлов и вставка их между соответствующими узлами оригинального списка
        ListNode curr = head;
        while (curr != null) {
            ListNode copy = new ListNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Второй проход: установка случайных указателей для копий
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Третий проход: восстановление оригинального списка и создание копии списка
        ListNode dummy = new ListNode(0);
        ListNode newCurr = dummy;
        curr = head;
        while (curr != null) {
            newCurr.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return dummy.next;
    }

    public static void removeDuplicate(ListNode head) {

        ListNode curr = head;
        while (curr != null) {
            ListNode innerCurr = curr;
            while (innerCurr.next != null) {
                if (innerCurr.next.val == curr.val) {
                    innerCurr.next = innerCurr.next.next;
                } else {
                    innerCurr = innerCurr.next;
                }
            }
            curr = curr.next;
        }
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}