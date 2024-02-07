import java.util.*;

public class ProFun08_Q3_65492 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        topK(arr);
    }

    private static void topK(int[] intArr) {
        Scanner number = new Scanner(System.in);
        int Arrlength = intArr.length;
        while (true) {
            System.out.print("Enter number : ");
            int num = number.nextInt();
            if(num == 0) break;
            int[] tmpArr = new int[Arrlength + 1];
            for (int i = 0; i < Arrlength; i++)
                tmpArr[i] = intArr[i];
            tmpArr[Arrlength] = num;

            // == sort Reverse ==
            int[] arrDesc = Arrays.stream(tmpArr).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
            // == sort Reverse ==

            for (int i = 0; i < Arrlength; i++)
                intArr[i] = arrDesc[i];
            System.out.println(Arrays.toString(intArr));
            System.out.println("");
        }
        number.close();
    }
}