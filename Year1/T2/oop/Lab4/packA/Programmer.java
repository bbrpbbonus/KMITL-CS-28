package packA;

import java.util.ArrayList;

public class Programmer extends Employee {
    public Programmer(String name, int exp, int sal){
        super();
        super.name = name;
        super.experience = exp;
        super.salary = sal;
    }

    private  ArrayList<String> skills;

    public void sayHi() {
        System.out.println("say hi from programmer");   
    }
    
    public String coding(){
        return "programmer coding";

    }    
}
