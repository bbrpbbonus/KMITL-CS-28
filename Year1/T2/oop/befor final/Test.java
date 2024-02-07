import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 22, 31, 455, 51);
        System.out.println(list.stream()
        .sorted(Comparator.reverseOrder())
        );
    }
}
