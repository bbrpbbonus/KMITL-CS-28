import java.util.Scanner;

public class ExpressionTreeTest {
    /** class ExpressionTreeTest **/
    
    public static void main(String[] args)
   {
    Scanner scan = new Scanner(System.in);
    System.out.println("Expression Tree Test");
    // String q = scan.nextLine();
    /** make object of ExpressionTree **/
    ExpressionTree et = new ExpressionTree();

    System.out.println("\nEnter equation in prefix form");
    String q = scan.nextLine();
    // et.buildTree(scan.next());
    // System.out.print(""+q);
    // et.toString(scan.next());
    System.out.print("\nPrefix  : "+q);
    et.toString(scan.next());
    // et.prefix();
    System.out.print("\n\nInfix   : ");
    et.infix();
    System.out.print("\n\nPostfix : ");
    et.postfix();
    // System.out.println("\n\nEvaluated Result : "+ et.evaluate());
    }
  }

