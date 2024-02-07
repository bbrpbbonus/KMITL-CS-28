import java.util.Stack;

public class Test {

    public static String prefixToInfix(String prefixExpression) {
        Stack<String> stack = new Stack<>();

        for (int i = prefixExpression.length() - 1; i >= 0; i--) {
            char c = prefixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            }
        }

        return stack.pop();
    }

    public static String postfixToInfix(String postfixExpression) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char c = postfixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            }
        }

        return stack.pop();
    }

    public static  String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String prefixExpression = "*+AB-CD";
        String infixExpression = prefixToInfix(prefixExpression);
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Prefix Expression : " + prefixExpression);
        System.out.println("Infix Expression : " + infixExpression);
        System.out.println("Postfix Expression : " + postfixExpression);
    }
}