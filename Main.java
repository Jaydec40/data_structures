package linkedlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    void addNode(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the name of the data file: ");
        String fileName = System.console().readLine();

        LinkedList linkedList = new LinkedList();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                linkedList.addNode(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
        }

        linkedList.printList();
    }
}
