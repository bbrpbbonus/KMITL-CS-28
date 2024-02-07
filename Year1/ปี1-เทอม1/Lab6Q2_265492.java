public class Lab6Q2_265492 {
    public static void main(String[] args) {
        String input = "10 10 10 01 10 10 ";
        String[] m = input.split(" ");
        int sum = 1;
        for(int i = 1; i < m.length; i++) {
            if(!m[i].equals(m[i-1])){
                sum++;
            }
        }
        System.out.println(sum);
    }
}