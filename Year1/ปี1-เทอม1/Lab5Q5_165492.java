public class Lab5Q5_165492{
    public static void main(String[] args){
        int n = 10;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if ( i == j){
                    System.out.print(" ");
                }else if (i == 9-j){
                    System.out.print(" ");
                }else{
                    System.out.print("x");
                }
            }
            System.out.println();
        }
        
        
    }
}