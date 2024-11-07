public class LList<T> implements ListInterface<T> {
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public LList() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(T item) throws ListException {
        if (item == null) {
            throw new ListException("Cannot add. Nulls not allowed");
        }

        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    public T delete(int pos) throws ListException {
        if (isEmpty()) {
            throw new ListException("Cannot delete. List is empty.");
        }

        if (pos < 1 || pos > count) {
            throw new ListException("Cannot delete. Bad Position.");
        }

        T temp;
        if (pos == 1) {
            temp = head.data;
            head = head.next;
            if (count == 1) {
                tail = null;
            }
        } else {
            Node prev = null;
            Node current = head;
            int i = 1;
            while (i < pos) {
                prev = current;
                current = current.next;
                i++;
            }
            temp = current.data;
            prev.next = current.next;
            if (pos == count) {
                tail = prev;
            }
        }

        count--;
        return temp;
    }

    public void insert(int pos, T item) throws ListException {
        if (item == null) {
            throw new ListException("Cannot insert. Nulls not allowed.");
        }

        if (pos < 1 || pos > count + 1) {
            throw new ListException("Cannot insert. Bad position.");
        }

        Node newNode = new Node(item);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            if (count == 0) {
                tail = newNode;
            }
        } else if (pos == count + 1) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node prev = null;
            Node current = head;
            int i = 1;
            while (i < pos) {
                prev = current;
                current = current.next;
                i++;
            }
            newNode.next = current;
            prev.next = newNode;
        }

        count++;
    }

    public T[] toArray() throws ListException {
        if (isEmpty()) {
            throw new ListException("List is empty.");
        }

        T[] array = (T[]) new Object[size()];

        Node current = head;
        int i = 0;
        while (current != null) {
            array[i] = current.data;
            current = current.next;
            i++;
        }

        return array;
    }

    public boolean ifEmpty() {
        return isEmpty();
    }

    public int size() {
        return count;
    }
}


