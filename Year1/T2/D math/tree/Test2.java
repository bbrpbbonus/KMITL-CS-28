import java.util.Scanner;
import java.util.Stack;

public class Test2 {
    
    // function to check if a character is an operator
    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }
    
    // function to get precedence of an operator
    static int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
     
            case '*':
            case '/':
                return 2;
     
            case '^':
                return 3;
        }
        return -1;
    }
    
    // function to convert infix to prefix
    static String infixToPrefix(String infix) {
        String prefix = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = infix.length()-1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (isOperator(c)) {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) > getPrecedence(c)) {
                    prefix += stack.pop();
                }
                stack.push(c);
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix += stack.pop();
                }
                stack.pop();
            } else {
                prefix += c;
            }
        }
        while (!stack.isEmpty()) {
            prefix += stack.pop();
        }
        return new StringBuilder(prefix).reverse().toString();
    }
    
    // main method to test the code
    public static void main(String[] args) {
        // String infix = "a+b*c-d/e^f";
        Scanner keyboard = new Scanner((System.in));
        // get input from user
        System.out.print("\nEnter the infix expression you want to convert : ");
        String numInfix = keyboard.next();
        String infix = String.valueOf(numInfix);
        String prefix = infixToPrefix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + prefix);
    }
}