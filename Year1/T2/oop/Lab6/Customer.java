public class Customer {

    private String name;
    private  MemberType memberType;

    public Customer(String n) {
        n = name;
        memberType = MemberType.None;
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
                memberType = MemberType.SILVER;
                break;
            case SILVER:
                memberType = MemberType.GOLD;
                break;
            case GOLD:
                memberType = MemberType.PREMIUM;
                break;
        }
    }

    private void demoteMemberType(){
        switch(memberType){
            case PREMIUM:
                memberType = MemberType.GOLD;
                break;
            case GOLD:
                memberType = MemberType.SILVER;
                break;
        }
    }

    public void showMembershipStatus(){
        System.out.println("You are now " + memberType);
    }
}
