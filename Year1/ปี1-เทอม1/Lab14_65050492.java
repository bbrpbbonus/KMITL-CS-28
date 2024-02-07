class Lab14_65050492 {

    class MyFixedPoint {
        public int data ;
        float getReal() {
            return data/1000.0f;
        }
        void adds(MyFixedPoint b) {
           
            this.data = this.data + b.data;
        }

        void subtracts(MyFixedPoint b) {
           
            this.data = this.data - b.data;
        }
        void multiplies(MyFixedPoint b) {
         
            this.data = (int)(this.data /(b.data/1000));
        }
        void divides(MyFixedPoint b) {
           
            this.data = (int)(this.data /(b.data/1000));
        }
    }
    class MyFloatingPoint {
        public float data;

        float getReal() {
            return data;
        }
        
        void adds(MyFloatingPoint b) {
            data = data + b.data;
        }
        
        void subtracts(MyFloatingPoint b) {
            data = data - b.data;
        }
        
        void multiplies(MyFloatingPoint b) {
            data = data * b.data;
        }
        
        void divides(MyFloatingPoint b) {
           data = data / b.data;
        }
    }

    public static void main(String[] args) {
        
        Lab14_65050492 Lab14_65050492 = new Lab14_65050492();
        Lab14_65050492.MyFixedPoint fixedPoint = Lab14_65050492.new MyFixedPoint();
        Lab14_65050492.MyFixedPoint addValueFix = Lab14_65050492.new MyFixedPoint();
        Lab14_65050492.MyFixedPoint subtractsValueFix = Lab14_65050492.new MyFixedPoint();
        Lab14_65050492.MyFixedPoint multiplyValueFix = Lab14_65050492.new MyFixedPoint();
        Lab14_65050492.MyFixedPoint divideValueFix = Lab14_65050492.new MyFixedPoint();
        addValueFix.data= 1555; // 7.555
        subtractsValueFix.data = 1000; // 2.25
        multiplyValueFix.data = 1000; // 4
        divideValueFix.data= 2000; // 2

        Lab14_65050492.MyFloatingPoint floatingPoint = Lab14_65050492.new MyFloatingPoint();
        Lab14_65050492.MyFloatingPoint addValueFloat = Lab14_65050492.new MyFloatingPoint();
        Lab14_65050492.MyFloatingPoint subtractsValueFloat = Lab14_65050492.new MyFloatingPoint();
        Lab14_65050492.MyFloatingPoint multiplyValueFloat = Lab14_65050492.new MyFloatingPoint();
        Lab14_65050492.MyFloatingPoint divideValueFloat = Lab14_65050492.new MyFloatingPoint();
        addValueFloat.data =1.555f;
        subtractsValueFloat.data = 1f;
        multiplyValueFloat.data = 1f;
        divideValueFloat.data = 2f;


        long startTime,endTime;
        startTime = System.currentTimeMillis();
        for(int i =0;i<10000;i++) {
            fixedPoint.adds(addValueFix);
            fixedPoint.subtracts(subtractsValueFix);
            fixedPoint.multiplies(multiplyValueFix);
            fixedPoint.divides(divideValueFix);
        }
        System.out.println(fixedPoint.getReal());
        endTime =System.currentTimeMillis();
        long duration = endTime-startTime;
        System.out.println("FixedPoint Duration = " + duration);


        
        startTime = System.currentTimeMillis();
        for(int i =0;i<10000;i++) {
            floatingPoint.adds(addValueFloat);
            floatingPoint.subtracts(subtractsValueFloat);
            floatingPoint.multiplies(multiplyValueFloat);
            floatingPoint.divides(divideValueFloat);
        }
        System.out.println(floatingPoint.getReal());
        endTime = System.currentTimeMillis();
        duration =endTime-startTime;
        System.out.println("FloatingPoint duration = " + duration);
    }

}