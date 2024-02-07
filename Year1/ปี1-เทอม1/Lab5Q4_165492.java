public class Lab5Q4_165492{
    public static void main(String[] args){
        String str = "WWWWMMMMWMWMWMWMMMWWWWWM";
        int m = 0;
        int w = 0; 
        for (int i = 0; i < str.length() ; i++){
            if (str.charAt(i) == 'M'){
                m++;                         
                //System.out.println(m);
            }
        }
        for (int j = 0; j < str.length() ; j++){
            if (str.charAt(j) == 'W'){
                w++;                         
                //System.out.println(w);
            }
        }
        System.out.println("Male : " +m);
        System.out.println("Female : " +w);        
    }
}