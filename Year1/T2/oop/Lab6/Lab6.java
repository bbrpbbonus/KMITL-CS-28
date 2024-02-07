public class Lab6 {
    public static void main(String[] args) {
        q1();
        System.out.println("--------------------- ");
        q2();
        System.out.println();
        q3();
    }

    static void q1(){
        int [] monthly = {1, 1, 1, 1, 1, -1, -1, 1, -1 };
        Customer yindee = new Customer("Yindee");
        int i = 0;
        for (; i < monthly.length; i++)
            yindee.spend(monthly[i]);
    }

    static void q2(){
        int [] monthly = {1, 1, 1, 1, 1, -1, -1, 1, -1 };
        Client preeda = new Client("preeda");
        int i = 0;
        for (; i < monthly.length; i++)
            preeda.spend(monthly[i]);
    }

    static void q3(){
        MemberTypeWithDiscount p = MemberTypeWithDiscount.GOLD;
        MemberTypeWithDiscount q = MemberTypeWithDiscount.GOLD;
        System.out.println(p == q);
    }
}
