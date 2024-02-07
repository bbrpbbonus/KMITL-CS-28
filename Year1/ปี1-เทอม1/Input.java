import java.util.Scanner;

public class Input {
    public static void main(String[] args) {    	
        Scanner input = new Scanner(System.in);    	
        //System.out.print("Enter an integer: ");
        int n = input.nextInt();
        //System.out.println("You entered " + number);
        input.close();
        if (n >0){
            if(n>=10){
                n -=10;
            }
            System.out.println(n);

        
    }
    

    }
   
}

    
    