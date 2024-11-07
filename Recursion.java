import java.util.Scanner;

public class Recursion {
    public static int factorial(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return n * factorial(n - 1); // Recursive case: call factorial with n-1 and multiply by n
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = scanner.nextInt();
        scanner.close();
        if (n < 0) {
            System.out.println("Error: input must be non-negative.");
        } else {
            int result = factorial(n);
            System.out.println(n + "! = " + result);
        }
    }
}
