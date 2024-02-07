//SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
contract EnumDemo {
    enum days_in_week {SUN, MON, TUE, WED, THU, FRI, SAT}
    days_in_week public today;
    function setToday(days_in_week _day) public {
        today = _day;
    }
    function getToDayByName() public view returns (string memory) {
        string memory result;
        if (today == days_in_week.SUN) {
            result = "Sunday";
        } 
        else if (today == days_in_week.MON) {
            result = "Monday";
        }
        else if (today == days_in_week.TUE) {
            result = "Tuesday";
        }
        else if (today == days_in_week.WED) {
            result = "Wednesday";
        }
        else if (today == days_in_week.THU) {
            result = "Thursday";
        }
        else if (today == days_in_week.FRI) {
            result = "Friday";
        }
        else  {
            result = "Saturday";
        }
        return result;
    }
}