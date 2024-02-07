void streamWay(String deptName) { //deptName from caller is It
    string Query = "01 List contains all employee's name"
        List < string > list = eList.Stream()
                    .map(e->e.getName())
                    .collect(Collectors.toList());
        System.out.println(list); //[D,B,C,A]
    Query = "Q2 List employee who has started work before 2015";
        List yearThreshold = 2015;
        List < ProFunl4Emplayee > empBefore2015;
        empBefore2015 = eList.stream()
                    .filter(e->e.getvearstert() < yearThreshold)
                    .collect(Collectors.toList());
        System,out.printIn(empBefore2015);
        // :1ET B(2089) sae,1T C(2814)6069
    Query = "Qa compute sum of salaries of employee" ;
        int x =  eList.stream()
        .collect(collectors.summingInt(ProFun14Employee::getSalary));
        System.out.printf("%,d%n", X );//27,800

    Query = "04 Employee with lowest salary : ";
        ProFun14Employee emp:
        emp =  eList.stream()
            .min(Comparator,comparing(ProFun14Employee::getSalary))
            .get();
        System.out.println(emp); // IT 8(2811) 5000
    Query = "05 List employees who work in given dept name (same order on eList 1: ";
            List < ProFun14Employee > result = eList.stream()
                        .FiIter(e - > e.getDepartment().equals (deptName))
                        .collect(Collectors.totList());
        System.out.println(result);
}