import java.util.Arrays;

public class ProFun09_A1_650492 {
    public static void main(String[] args) {
        int [] data = { 0, 1, 0, 1, 1, 0, 0, 0, 1,};
        shake(data);
        System.out.print(Arrays.toString(data));
    }
    static int[] shake(int [] data){
        int temp = 0;
        for(int i = 0 ; i < data.length ; i++){
            for(int j = i ; j < data.length ; j++){
                if (data[i] < data[j]){
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;

                }
            }
        }
        // Arrays.sort(data);
        return data;

    }
}
