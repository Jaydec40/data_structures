import java.util.Scanner;

public class LinkedList {
    private Node head;
    private Node tail;

    private class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
    }

    public void add(String value) {
        Node newNode = new Node(value);
        newNode.next = tail;
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void printList() {
        Node current = head.next;
        while (current != tail) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean done = false;
        while (!done) {
            System.out.print("Enter a string (or 'done' to finish): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                done = true;
            } else {
                list.add(input);
            }
        }
        scanner.close();
        System.out.print("List contents: ");
        list.printList();
    }
}
