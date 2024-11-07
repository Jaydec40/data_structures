import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
    private Node root;
    
    private class Node {
        int key;
        Node left, right;
        
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    
    public BinarySearchTree() {
        root = null;
    }
    
    public void insert(int key) {
        root = insertRec(root, key);
    }
    
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        
        return root;
    }
    
    public void delete(int key) {
        root = deleteRec(root, key);
    }
    
    private Node deleteRec(Node root, int key) {
        if (root == null) return root;
        
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            
            root.key = minValue(root.right);
            
            root.right = deleteRec(root.right, root.key);
        }
        
        return root;
    }
    
    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    public void printBFS() {
        if (root == null) return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                System.out.print(current.key + " ");
                
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            
            System.out.println();
        }
    }
    
    public void printPostOrder() {
        if (root == null) return;
        
        printPostOrderRec(root);
    }
    
    private void printPostOrderRec(Node root) {
        if (root == null) return;
        
        printPostOrderRec(root.left);
        printPostOrderRec(root.right);
        System.out.print(root.key + " ");
    }
    
        public void printInOrder() {
        if (root == null) return;
        
        printInOrderRec(root);
        System.out.println();
    }
    
    private void printInOrderRec(Node root) {
        if (root == null) return;
        
        printInOrderRec(root.left);
        System.out.print(root.key + " ");
        printInOrderRec(root.right);
    }
    
    public void printPreOrder() {
    printPreOrder(root);
}

      private void printPreOrder(Node node) {
         if (node != null) {
        System.out.print(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}

    
    
    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Binary Search Tree Menu");
            System.out.println("1. Add an item");
            System.out.println("2. Delete an item");
            System.out.println("3. Print the tree breadth-first");
            System.out.println("4. Print the tree in post-order traversal");
            System.out.println("5. Print tree in-order");
            System.out.println("6. Print the tree pre-order traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the item to be added: ");
                    int item = scanner.nextInt();
                    insert(item);
                    System.out.println(item + " added to the tree.");
                    break;
                case 2:
                    System.out.print("Enter the item to be deleted: ");
                    int key = scanner.nextInt();
                    delete(key);
                    System.out.println(key + " deleted from the tree.");
                    break;
                case 3:
                    System.out.println("Tree breadth-first:");
                    printBFS();
                    break;
               case 4:
                  System.out.println("Post-order traversal:");
                     printPostOrder();
                     System.out.println();
            break; 
            
             case 5:
                System.out.println("In-order traversal:");
                printInOrder();
                System.out.println();
                break;
                case 6:
                   System.out.println("Pre-order traversal:");
                   printPreOrder();
                   System.out.println();
                  break;
            case 7:
               return;               
               default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    
 

    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.printMenu();
    }
}
