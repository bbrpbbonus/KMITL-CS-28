import java.util.Scanner;
import java.util.Stack;

public class Tree {
    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static String infixToPrefix(String infix) {
        String prefix = "";
        Stack<Character> operatorsPre = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; --i) {
            char ch = infix.charAt(i);

            if (precedence(ch) > 0) {
                while (operatorsPre.isEmpty() == false && precedence(operatorsPre.peek()) > precedence(ch)) {
                    prefix += operatorsPre.pop();
                }
                operatorsPre.push(ch);
            } else if (ch == '(') {

                char x = operatorsPre.pop();
                while (x != ')') {
                    prefix += x;
                    x = operatorsPre.pop();
                }

            } else if (ch == ')') {
                operatorsPre.push(ch);
            } else {
                prefix += ch;
            }
        }

        while (!operatorsPre.isEmpty()) {
            prefix += operatorsPre.pop();
        }

        String reversedPrefix = "";
        for (int i = prefix.length() - 1; i >= 0; i--) {
            reversedPrefix += prefix.charAt(i);
        }
        return reversedPrefix;
    }

    char a[] = new char[100];
    int top = -1;

    void push(char c) {
    try {
    a[++top] = c;
    } catch (StringIndexOutOfBoundsException e) {
    System.out.println("Stack full, no room to push, size=100");
    System.exit(0);
    }
    }

    char pop() {
    return a[top--];
    }

    boolean isEmpty() {
    return (top == -1) ? true : false;
    }

    char peek() {
    return a[top];
    }

    static Stack<Character> operatorsPost = new Stack<>();
    // Stack<Character> operators = new Stack<>();

    private static String infixToPostfix(String infix)
    // converts an infix expression to postfix
    {
        char symbol;
        String postfix = "";
        for (int i = 0; i < infix.length(); ++i)
        // while there is input to be read
        {
            symbol = infix.charAt(i);
            // if it's an operand, add it to the string
            if (Character.isLetter(symbol))
                postfix = postfix + symbol;
            else if (symbol == '(')
            // push (
            {
                operatorsPost.push(symbol);
            } else if (symbol == ')')
            // push everything back to (
            {
                while (operatorsPost.peek() != '(') {
                    postfix = postfix + operatorsPost.pop();
                }
                operatorsPost.pop(); // remove '('
            } else
            // print operators occurring before it that have greater precedence
            {
                while (!operatorsPost.isEmpty() && !(operatorsPost.peek() == '(') && prec(symbol) <= prec(operatorsPost.peek()))
                    postfix = postfix + operatorsPost.pop();
                    operatorsPost.push(symbol);
            }
        }
        while (!operatorsPost.isEmpty())
            postfix = postfix + operatorsPost.pop();
        return postfix;
    }

    static int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }

    public static void main(String[] args) {
        // String exp = "A+B*(C^D-E)";
        // create an input stream object
        Scanner keyboard = new Scanner((System.in));
        // get input from user
        System.out.print("\nEnter the infix expression you want to convert : ");
        String infix = keyboard.next();
        // output as postfix
        System.out.println("------------------------------ ");
        System.out.println("Infix Expression : " + infix);
        System.out.println("Prefix Expression : " + infixToPrefix(infix));
        System.out.println("Postfix Expression : " + infixToPostfix(infix));
    }
}
