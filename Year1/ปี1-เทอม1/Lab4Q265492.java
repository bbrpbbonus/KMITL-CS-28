import java.util.Scanner;
import java.util.Arrays;
class Lab4Q265492 {
    public static void main(String[] args){
        System.out.println("\t\t----Shopping to day Get 2 free 1 !!!!----");
        Scanner keyboard = new Scanner (System.in);
        System.out.print("The price of the first item to be purchased   : ");        
        int st = keyboard.nextInt();        
        System.out.print("The price of the seccond item to be purchased : ");        
        int nd = keyboard.nextInt();
        System.out.print("The price of the third  item to be purchased  : ");        
        int rd  = keyboard.nextInt();
        System.out.print("total :  "+(st+nd+rd) );
        System.out.println("   Bath ");
                
        keyboard.close();
             
        int [] arr = {st,nd,rd,}; 
        int min = Arrays.stream( arr ).min().getAsInt();
        System.out.print("Get 2 free 1  reduced to =>  : "+((st+nd+rd)-min) );
        System.out.println("   Bath ");
    }       
}