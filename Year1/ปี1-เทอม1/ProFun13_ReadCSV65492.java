import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
public class ProFun13_ReadCSV65492 {
    static Employee[] empList = new Employee[2];
    public static void main(String[] args) { 
        // Employee[] empList = new Employee[20]; //ข้อ 1
        // Employee[] empList = new Employee[2]; //ข้อ 2
        int n = 0 ,l=0;
        boolean notFull = true;
        try(Scanner input = new Scanner(Paths.get("employee.csv"))) {
            while (input.hasNext() && notFull) {
                n++;
                try {
                    String row = input.nextLine();
                    String[] dataFields = row.split(",");
                    int employeeId = Integer.parseInt(dataFields[0]);
                    String firstName = dataFields[1];
                    String lastName = dataFields[2];
                    double salary = Double.parseDouble(dataFields[3]);
                    Employee person = new Employee(employeeId,firstName,lastName,salary);
                    try{
                        empList[l] = person;
                        l++;
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Array is full – cannot load remaining row");
                        notFull = false;
                    }
                }
                catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.printf("Data format error at line: %d; %s%n",n, e);
                }
         }
        } 
        catch (NoSuchFileException e) {
            System.out.printf("File not found: %s%n", e);
        }
        catch (IOException e) {
            System.out.printf("Unknown I/O error: %s%n", e);
            e.printStackTrace();
        } 
        printAllEmployee(empList);
        System.out.println();
        printEmpList();

}
    static void printAllEmployee(Employee[] empList){
        System.out.printf("%s%s%s%s%n", "Emp Id",
        "First Name", "Last Name", "Salary");
        for (Employee i : empList){
            if(i == null) break;
            System.out.println(i.getEmployeeInfo());
        }
    }
    static void printEmpList(){
        System.out.printf("%s%s%s%s%n", "Emp Id",
        "First Name", "Last Name", "Salary");
        for (Employee i : empList){
            if(i == null) break;
            System.out.println(i.getEmployeeInfo());
        }

    }
}



class Employee {
    private int empId;
    private String firstName, lastName;
    private double salary;
    public Employee() {
        this(0, "","", 0.0);
    }
    public Employee(int empId, String firstName, String lastName, double salary) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public int getEmpId() {
        return empId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public String getEmployeeInfo() {
        return empId + " " + firstName + " " + lastName + " " + salary;
    }
}