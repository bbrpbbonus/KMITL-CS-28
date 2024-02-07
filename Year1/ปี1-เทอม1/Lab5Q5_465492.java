public class Lab5Q5_465492 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 0; k < (6-j) - i; k++) {
                    System.out.print(" ");
                }
    
                for (int k = 0; k < j+i; k++) {
                    System.out.print("*");
                }
    
                for (int l = 0; l < (j-1)+i; l++) {
                    System.out.print("*");
                }
    
                System.out.println();
            }
        }

        for  (int m = 0; m < 3; m++) {
            for (int n = 0; n < 4; n++) {
                System.out.print(" ");
            }

            for (int o = 0; o < 3; o++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}