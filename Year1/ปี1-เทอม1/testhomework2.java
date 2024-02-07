public class testhomework2{
    public static void main(String[] args){

        int[] d = { 9, 20, 6, 10, 14, 8, 60, 11 };
            //int[] d = { 9, 20, 6, 10, 14, 8, 60, 11 };
            // int [] d = {9, 11, 13, 14, 15, 17, 19, 22};
        int markIdx = 0; 
        int magic = 0;
        int leastValue = d[markIdx];
        int iter = 1;
        int currentExamineIdx = 0;
        int tmp = 0;
        for (iter = 0; iter < d.length - 1; iter++){
            markIdx = iter;
            for (currentExamineIdx = iter; currentExamineIdx < d.length; currentExamineIdx++){
                if (d[markIdx] > d[currentExamineIdx]){
                    markIdx = currentExamineIdx; 
                    magic++;
                }
            }
            tmp = d[iter];
            d[iter] = d[markIdx];
            d[markIdx] = tmp; 
            for (int i = 0; i < d.length; i++)
                System.out.print(d[i] + " ");
            System.out.println("magic = " + magic);
            System.out.println(tmp);
            
        }
        System.out.println(leastValue);
    } 
}