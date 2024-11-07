import java.util.Scanner;

public class BinarySearchTreeMenu {
    private static BinarySearchTree tree = new BinarySearchTree();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Binary Search Tree Menu:");
            System.out.println("1. Add an item");
            System.out.println("2. Delete an item");
            System.out.println("3. Search for an item");
            System.out.println("4. Print the tree (in-order traversal)");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add: ");
                    int addValue = scanner.nextInt();
                    tree.add(addValue);
                    System.out.println(addValue + " added to the tree.");
                    break;
                case 2:
                    System.out.print("Enter the value to delete: ");
                    int deleteValue = scanner.nextInt();
                    
                    if (tree.delete(deleteValue)) {
                        System.out.println(deleteValue + " deleted from the tree.");
                    } else {
                        System.out.println(deleteValue + " not found in the tree.");
                    }
                    
                    break;
                case 3:
                    System.out.print("Enter the value to search for: ");
                    int searchValue = scanner.nextInt();
                    
                    if (tree.search(searchValue)) {
                        System.out.println(searchValue + " found in the tree.");
                    } else {
                        System.out.println(searchValue + " not found in the tree.");
                    }
                    
                    break;
                case 4:
                    System.out.print("Tree contents (in-order traversal): ");
                    tree.inorderTraversal();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
