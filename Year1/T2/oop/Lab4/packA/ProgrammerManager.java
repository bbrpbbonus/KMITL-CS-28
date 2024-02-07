package packA;

public class ProgrammerManager extends Programmer{
    
    public ProgrammerManager(String name, int exp, int sal){
        super(name, exp, sal);
    }
  
    public void sayHi(){
        System.out.println("coding in [solidity, typescript]"); 
    }
   
    public String coding() {
        return "Programmer Coding";
    }

    public int evaluate(Programmer p) {
        return p.salary += (p
        .salary*15)/100;
    }

    public String toString() {
        return "ManagerProgrammer [name="+name+","+ "experience="+ experience +","+"Salary="+ salary +"]";
    }
    
}
