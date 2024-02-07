public class Lab7Q2_65492{
    public static void main(String[] args) {
        int [] data = {7,1,2,-1,3,4,10,-12,3,21,-9};        
        int max = maxElement(data);
        System.out.println(max);
        
    }
    static int maxElement(int [] arr) {
        
        int cur = arr[0];

        for (int idx = 0; idx < arr.length; idx++){
            if(arr[idx] > cur){
            cur = arr[idx];
            }
        }
        return cur;
        }
}