import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main8 {
    public static void main(String[] args){
        // q0();
        q1_halfEachNumber();
    }
    static void q0(){
        HalfValueInterface bb = new HalfValueInterface(){
            public void printHalf(int p){
                System.out.print(p/2);
            }
        };
        bb.printHalf(12);
    }

    public static void q1_halfEachNumber() {
        List<Integer> nums = Arrays.asList(100, 105);
        HalfValueInterface halfVal = n -> System.out.println(n / 2);/* q1.1 */
        for (int n : nums) {
            halfVal.printHalf(n);
        }
        Consumer<Integer> consumer = n -> System.out.println(n / 2);/* q1.2 */
        for (int n : nums) {
            consumer.accept(n);
        }
        Consumer<Integer> halfMe = n -> System.out.println(n / 2);
        nums.forEach(i -> halfMe.accept(i));/* q1.3 */
        // nums.forEach();
        


        // NumberProcessor np = new NumberProcessor();
        // nums.forEach(np/* q1.5 */);
    }
}