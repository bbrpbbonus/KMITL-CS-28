package packA;

public class Accountant extends Employee {

    private static String companyName = "berk barn jamkad";
    
    private int experience;

    private String specialty;

    public void sayHi() {
        System.out.println("say hi from Accounatant");
    }

    public String tellProfit() {
        return "tellprofit form Accounatant";
    }
    public static String tellMyRole() {
        return "I am an accountant at " + companyName;
    }
    
}
