import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        float[][] data = {{2f,3f,-4f,3f},
                        {1f,-3f,2f,2f},
                        {2f,-1f,-1f,-1f}
                    };
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("Equation%d : %.0fx %.0fy %.0fx = %.0f", i + 1, data[i][0], data[i][1], data[i][2], data[i][3]));
        }
        int[] xyz = findXYZ(data);
        System.out.println(String.format("\n[X = %d],[Y = %d],[Z = %d]",xyz[0],xyz[1],xyz[2]));
        
    }
    public static int[] findXYZ(float[][] data){
        float[][] arr = Gussian(data);
        int[] xyz = {0,0,0};
        xyz[2] = (int) (arr[2][3]/arr[2][2]);
        xyz[1] = (int) ((arr[1][3]-(xyz[2]*arr[1][2]))/arr[1][1]);
        xyz[0] = (int) ((arr[0][3]-((xyz[2]*arr[0][2])+(xyz[1]*arr[0][1])))/arr[0][0]);
        return xyz;
    }
    public static float[][] Gussian(float[][] data){
        System.out.println("===Before Gussian===");
        printArray(data);
        for (int i = 0; i < data.length; i++) {
            float main = data[i][i];
            for (int j = 0; j < data.length; j++) {
                if(j>i){
                    float sub = data[j][i];
                    for (int k = 0; k < data[0].length; k++) {
                        data[j][k] = (float) ((data[j][k] - ((sub/main)*data[i][k])))*main; 
                    }
                }
            }
        }
        System.out.println("\n===After Gussian===");
        printArray(data);
        return data;

    }
    public static void printArray(float[][] data){
        for (float[] fs : data) {
            System.out.println(Arrays.toString(fs));
        }

    }


}
