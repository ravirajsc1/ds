package ravi.algo.concepts;

import java.util.List;

class EduLinkedList {
    ListNode head;

    // Constructor to initialize from a list of values
    public EduLinkedList(List<Integer> values) {
        this.head = null;
        if (values != null && !values.isEmpty()) {
            createLinkedList(values);
        }
    }

    // Function to create the linked list from a list of values
    public void createLinkedList(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            head = null;
            return;
        }

        head = new ListNode(values.get(0));
        ListNode current = head;
        for (int i = 1; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
        head = makeCircular(head);
    }

    // Function to make the list circular
    public ListNode makeCircular(ListNode head) {
        if (head == null) return null;

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;  // Make it circular
        return head;
    }

    // Function to display the linked list
    public static void display(ListNode head, int limit) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        ListNode current = head;
        ListNode first = head;
        int count = 0;

        while (current != null && count < limit) {
            System.out.print(current.value);
            current = current.next;
            if (current != first && count < limit - 1) {
                System.out.print(" -> ");
            }
            count++;
            if (current == first) break;
        }
        if (count >= limit) {
            System.out.println(" -> ... (back to head)");
        } else {
            System.out.println(" -> ... (back to head)");
        }
    }
}