import java.util.Scanner;

public class Hw3 {
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

    private static String infixToPrefix(String infix) {
        return infix;
    }

    
}
