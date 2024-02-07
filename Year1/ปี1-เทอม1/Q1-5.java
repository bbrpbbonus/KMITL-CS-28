import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProFun14StreamDemo {
    ArrayList < ProFun14Employee > eList;

    ProFun14StreamDemo(){
        eList = new ArrayList<>();
        eList.add(new ProFun14Employee("D","HR",9000,2016));
        eList.add(new ProFun14Employee("B","IT",5000,2011));
        eList.add(new ProFun14Employee("C","IT",6000,2014));
        eList.add(new ProFun14Employee("A","Finance",7000,2018));
    }

void oldWay(){
    System.out.println(eList);
    //
    //
}
public static void main(String[] args) {
    ProFun14StreamDemo demo = new ProFun14StreamDemo();
    //demo.steamWay();
    demo.oldWay();
}
}