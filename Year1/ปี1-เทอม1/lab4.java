import java.util.Scanner;

class Main {
    public static void main(String[] args){
        System.out.print("Please enter your °F : " );        
        Scanner temp = new Scanner (System.in);        
        float f = temp.nextFloat();
        
        System.out.println("your °C : " +((f - 32 )/ 9)* 5 +"  °C "); 
  
        temp.close();
    }
}