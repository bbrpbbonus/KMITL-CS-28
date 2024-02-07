import java.util.*;
import java.util.Stack;

public class Infixtopost {
    private static final Map<Character, Integer> PRECEDENCE_MAP = new HashMap<>();
    static {
        PRECEDENCE_MAP.put('^', 3);
        PRECEDENCE_MAP.put('*', 2);
        PRECEDENCE_MAP.put('/', 2);
        PRECEDENCE_MAP.put('+', 1);
        PRECEDENCE_MAP.put('-', 1);
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '('
                        && hasHigherPrecedence(operatorStack.peek(), c)) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        return PRECEDENCE_MAP.get(op1) >= PRECEDENCE_MAP.get(op2);
    }
    
    public static void main(String argv[]) {
        String infix;
        // create an input stream object
        Scanner keyboard = new Scanner((System.in));
        // get input from user
        System.out.print("\nEnter the infix expression you want to convert: ");
        infix = keyboard.next();
        // output as postfix
        System.out.println("Postfix expression for the given infix expression is:" + infixToPostfix(infix));
    }
}
