public class Lab7Q3_65492{
    public static void main(String[] args) {
        // int date = 29;
        // int month = 3;
        // int year = 2004;
        // int myBD = 1;
        numDaysFromDate(6, 6, 2004, 4);
    }
    static void numDaysFromDate(int date , int month , int year, int myBD) {
        int daysBornTil31Dec2021 = 0;
        for (int i = year + 1 ; i <= 2021 ; i++){
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0 ){
                daysBornTil31Dec2021 += 366;
            }else{
                daysBornTil31Dec2021 += 365;
            }            
        }
        for(int j = month ; j <= 12 ; j++){
            if (j == 4 ||j == 6 ||j == 9 ||j == 11 ){
                daysBornTil31Dec2021 += 30;
            }
            else if(j == 1 ||j == 3 ||j == 5 ||j == 7 ||j ==8 ||j == 10 ||j == 12){
                daysBornTil31Dec2021 += 31;
            }
            else{
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ){
                    daysBornTil31Dec2021 += 29;
                }else{
                    daysBornTil31Dec2021 += 28;
                }
            }  
        }
        int daysBornTil2Jan2022 = daysBornTil31Dec2021 + 2 - date; // shift to Sunday Jan 02 2022
        String str = showResult(date, month, year, myBD, daysBornTil2Jan2022);
        System.out.println(str);
    }
    static String showResult(int date, int month, int year, int myBD, int fromNumDaysFromDate) {
        String[] dayName = { "Sunday", "Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday" };
        int dayFromSun = 0;
        int modResult = fromNumDaysFromDate % 7;
        dayFromSun = 7 - modResult;
        String str = String.format("You were born on %s and have been born for -> %d days (2 Jan 2022).\nYour program says -> %s.", dayName[myBD], fromNumDaysFromDate, dayName[dayFromSun]);
        return str;
        }   
}