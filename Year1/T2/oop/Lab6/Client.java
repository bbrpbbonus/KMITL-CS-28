public class Client implements Canpay {
    
    private String name;
    private MemberTypeWithDiscount memberType;

    public Client(String n) {
        this.name = n;
        memberType = MemberTypeWithDiscount.None;
    }
    public void spend(int direction) {
        switch(direction){
            case 1:
                promoteMemberType();
                break;
            case -1:
                demoteMemberType(); 
        }
        showMembershipStatus();
    }

    private void promoteMemberType(){
        switch(memberType){
            case None:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.PREMIUM;
                break;
        }
    }

    private void demoteMemberType(){
        switch(memberType){
            case PREMIUM:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
        }
    }
    
    public void showMembershipStatus(){
       // System.out.println("You are now " + memberType+" "+memberType.getProductDiscount()+"%discount on Product" );
        String s = String.format("Your are now %s %.0f%%discount on Product  %.0f%% on service ",memberType, memberType.getProductDiscount(), memberType.getServiceDIscount());
        System.out.println(s);
        //System.out.println("\"%discount on Product\"");
    }


}
