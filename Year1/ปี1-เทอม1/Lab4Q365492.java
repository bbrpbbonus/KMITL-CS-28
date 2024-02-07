public class Lab4Q365492{
    public static void main(String ... args) {
        int amountCharge = 0;
        int hrsPark = 0;
        int remaining = 0;

        for (int i = 0; i < args.length; i++){
            hrsPark = Integer.parseInt(args[i]);
            remaining =hrsPark;
            amountCharge = 0;
            

            while (remaining > 0 ){
                if (remaining <= 2){
                    amountCharge += 4;
                    remaining -= 2;
                }else if (remaining > 2 && remaining <=4){
                    amountCharge +=3;
                    remaining -=1;
                }else if (remaining > 4 && remaining < 18){
                    amountCharge += 1;
                    remaining -= 1;
                }else {
                    amountCharge += 24;
                    remaining -= 24;

                }
            }



            System.out.printf("Parking for %d hrs , pay %d bath.%n", hrsPark,amountCharge);
        }
    }
}