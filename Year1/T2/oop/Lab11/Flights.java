public class Flights {
    private String code;
    private City source;
    private City destination;
    private DayOfWeek day;
    private Time departTime;
    
    public Flights(String code, City bkk, City city, DayOfWeek day, Time time) {
        this.code = code;
        source = bkk;
        destination = city;
        this.day = day;
        departTime = time;
    }
    public String toString(){
        return String.format("Flight [%s,%s to %s, %s, Time=%s]", code,source,destination,day,departTime);
    }
    
}
