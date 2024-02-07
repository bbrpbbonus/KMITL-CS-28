package packA;

import java.lang.Math;

public class Salesperson extends Employee{

    private int target;

    public void sayHi(){
        System.out.println("sayHi from saleperson");
    }

    // public void setSalary() {
    //     this.salary += (salary*15)/100;
    // }

    public void setSalary(int incAmout){
        salary += incAmout;
    }
    
    public String makeQuotation(){
        return  "Dear value customer," + " "+ (int)(Math.random()*1000) +" " + "is my best offer.";
    }
}
