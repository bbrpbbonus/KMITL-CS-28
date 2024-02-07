class Employee {
    private String id ;
    private String name ;
    private Double salary ;

    public void setID(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public void displayEmployee(){
        System.out.println("ID = "+this.id);
        System.out.println("Name = "+this.name);
        System.out.println("Salary = "+this.salary);
    }

    public String getName(){
        return this.name;
    }
    public Double getSalary(){  
        return this.salary;
    }
}
public class Main{
    public static void main (String [] args){
        Employee e1 = new Employee();
        e1.setID("1");
        e1.setName("Boriphat");
        e1.setSalary(3000.0);
        //e1.displayEmployee();

        System.out.println("Name = "+e1.getName());
        System.out.println("Salary = "+e1.getSalary());
        System.out.println("Hello World"+e1.getSalary());

        Employee e2 = new Employee();
        e2.setID("2");
        e2.setName("Napat");
        e2.setSalary(5000.0);
        //e2.displayEmployee();
        System.out.println("Name = "+e2.getName());
        System.out.println("Salary = "+e2.getSalary());

    }
}