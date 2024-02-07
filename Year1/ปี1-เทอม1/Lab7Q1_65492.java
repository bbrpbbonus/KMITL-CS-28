import java.util.Scanner;
public class Lab7Q1_65492 {
    public static void main(String[] args) {
        int fact = 1;
        System.out.print("Enter your number : ");
        Scanner input = new Scanner(System.in); 
        
        int number = input.nextInt();
        
        fact = factorial(number);
        

        System.out.println("Factorial of "+ number +" is "+fact);
        input.close();
    }
        static int factorial(int n) {
            if(n == 0)
            return 1;
            else
            return(n* factorial(n-1));
        }
    
}
