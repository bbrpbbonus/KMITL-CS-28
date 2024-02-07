package packA;

import java.lang.Math;

public class Salesperson extends EmpTmp{

    private int target;

    public Salesperson(String name ,int exp ,int sal ,int assignedTarget) {
        super(name ,exp ,sal);
        target = assignedTarget;
    }

    public Salesperson(String n ,int exp) {
        super(n);
        super.setExperience(exp);
    }   

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget(){
        return target;
    }

    
    public void setSalary() {
        this.salary += (salary*10)/100;
    }

    @Override
    public void setSalary(int incAmt){
        salary += incAmt;
    }

    public String makeQuotation(){
        return  "Dear value customer," + " "+ (int)(Math.random()*1000) +" " + "is my best offer.";
    }

    @Override
    public String toString() {
        return "Salesperson [target=" + target + " Programmer " + "[name=" + super.getName() + 
        ", salary=" + super.getSalary() +", experience=" + super.getExperience() + "]" +" ] ";
    } 
    // mr.salesperson's salary was 150 -> Salesperson [target=5000 Programmer [name=mr.salesperson, salary=250, experience=5] ]
    // Salesperson [target=5000 Programmer [name=mr.salesperson, salary=275, experience=5] ]
    // Salesperson [target=9000 Programmer [name=mr.kayan, salary=260, experience=4] ]
    
    

}
