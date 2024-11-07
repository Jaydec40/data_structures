import javax.swing.JOptionPane;

public class StackClass {
    
    private int[] stack;
    private int top;
    
    public StackClass(int size) {
        stack = new int[size];
        top = -1;
    }
    
    public void push(int value) {
        if (top == stack.length - 1) {
            JOptionPane.showMessageDialog(null, "Stack overflow");
            return;
        }
        
        top++;
        stack[top] = value;
    }
    
    public int pop() {
        if (top == -1) {
            JOptionPane.showMessageDialog(null, "Stack underflow");
            return -1;
        }
        
        int value = stack[top];
        top--;
        return value;
    }
    
    public boolean isBalanced() {
        if (top == -1) {
            JOptionPane.showMessageDialog(null, "Stack is empty");
            return true;
        }
        
        int sum = 0;
        for (int i = 0; i <= top; i++) {
            sum += stack[i];
        }
        
        int midpoint = sum / 2;
        int runningSum = 0;
        for (int i = 0; i <= top; i++) {
            runningSum += stack[i];
            if (runningSum == midpoint) {
                JOptionPane.showMessageDialog(null, "Stack is balanced");
                return true;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Stack is unbalanced");
        return false;
    }
    
    public static void main(String[] args) {
        StackClass stack = new StackClass(5);
        
        while (true) {
            String input = JOptionPane.showInputDialog("Enter a number to push onto the stack (or type 'q' to quit):");
            if (input.equals("q")) {
                break;
            }
            
            try {
                int value = Integer.parseInt(input);
                stack.push(value);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input: " + input);
            }
        }
        
        stack.isBalanced();
    }
}
