public class Lab3Q365492 {
    public static void main (String[] args){
        int sumnum =0;
        for (int numx=0 ; numx < 1000 ; numx++) {
            if ( numx % 3 == 0 || numx % 5 == 0){
                sumnum += numx;
            }
        }
        System.out.println(sumnum);
    }

}