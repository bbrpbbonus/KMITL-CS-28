import packA.*;
import java.util.ArrayList;

public class Lab3Polymorphism {

    public static void main(String[] args) {
        q1();

    }
    static void q1(){
        ArrayList<EmpTmp> aList = new ArrayList<>();
        aList.add(new Accountant("goodAtmyjob", 7, 6, 390, "sing"));
        aList.add(new Accountant("canRap", 4, 9, 480, "rap"));
        aList.add(new Salesperson("mr.Salesperson", 5, 150, 5000));
        aList.add(new Salesperson("mr.kayan", 2, 300, 9000));
        aList.add(new Programmer("keng", 2, 300));
        aList.add(new EmpTmp("Invisible", 2, 120));

        System.out.println("Upcasing");
        for (EmpTmp e : aList) 
            e.sayHi();

        System.out.println("Downcasing");
        for (EmpTmp e : aList){
            String str;
            if(e instanceof Accountant){
                Accountant m = (Accountant)e;
                str = m.tellProfit(); 
            }else if (e instanceof Salesperson){
                Salesperson m = (Salesperson)e;
                str = m.makeQuotation(); 
            }else if (e instanceof Programmer){
                Programmer m = (Programmer)e;
                str = m.coding(); 
            }else{
                str = " ";
            }  
            System.out.println(str);
        }        
    }
}
