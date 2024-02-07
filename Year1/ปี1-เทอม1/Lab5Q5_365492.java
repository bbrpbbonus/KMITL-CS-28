public class Lab5Q5_365492 {
    public static void main(String[] args) {
        int n = 4;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3-i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i+1; k++) {
                System.out.print("P");
            }

            for (int l = 0; l < i; l++) {
                System.out.print("P");
            }

            System.out.println();

        }
    }
}