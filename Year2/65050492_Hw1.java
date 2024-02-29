import java.util.Scanner;

public class Hw1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficients A, B, and C for the quadratic equation Ax^2 + Bx + C = 0:");

        System.out.print("Enter A: ");
        double A = scanner.nextDouble();

        while (A == 0) {
            System.out.print("A must be non-zero. Please enter a valid value for A: ");
            A = scanner.nextDouble();
        }

        System.out.print("Enter B: ");
        double B = scanner.nextDouble();

        System.out.print("Enter C: ");
        double C = scanner.nextDouble();

        double discriminant = B * B - 4 * A * C;

        if (discriminant > 0) {
            double root1 = (-B + Math.sqrt(discriminant)) / (2 * A);
            double root2 = (-B - Math.sqrt(discriminant)) / (2 * A);
            System.out.println("Roots are real and different.");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);
        } else if (discriminant == 0) {
            double root = -B / (2 * A);
            System.out.println("Roots are real and the same.");
            System.out.println("Root = " + root);
        } else {
            System.out.println("Roots are complex and different.");
            double realPart = -B / (2 * A);
            double imaginaryPart = Math.sqrt(Math.abs(discriminant)) / (2 * A);
            System.out.println("Root 1 = " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2 = " + realPart + " - " + imaginaryPart + "i");
        }

        scanner.close();
    }
}
