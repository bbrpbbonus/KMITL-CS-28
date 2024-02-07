public enum MemberTypeWithDiscount {

    None(0, 0),
    SILVER(0.5,0.5 ),
    GOLD(1.0, 2.0),
    PREMIUM(3.0, 4.5);

    private double productDiscountRate;
    private double serviceDiscountRate;

    MemberTypeWithDiscount(double p , double s){
        productDiscountRate = p;
        serviceDiscountRate = s;
    }
    
    public double getProductDiscount(){
        return productDiscountRate*10;
    }

    public double getServiceDIscount(){
        return serviceDiscountRate*10;
    }

    
}
