public class Lab5Q365492{
    public static void main(String[] args){
        int sumnum = 0;
        
        for (int num = 0;  num < 200 ; num++){
            if (num %10 == 0){
                continue;          
            }                  
            sumnum+=num;
        }
        System.out.println(sumnum);
    }
}