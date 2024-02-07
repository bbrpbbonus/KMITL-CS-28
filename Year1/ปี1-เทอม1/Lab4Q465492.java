public class Lab4Q465492{
    public static void main(String...args){
        int i = 2;
        int sumnum = 0;
        int j = 0;
        while (j < 3){
            for (int pfnum = 1; pfnum < i; pfnum++ ){
                if( i % pfnum == 0 ) {
                    sumnum += pfnum;
                }
            }
            if (sumnum == i){
                System.out.println("Perfect number : "+i);
                j++;
            }
            sumnum = 0;
            i++;
        }

    }
}