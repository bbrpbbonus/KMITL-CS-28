// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.1;

contract DayUnits {
    uint public oneSecond = 1 seconds;
    uint public oneMinute = 1 minutes;
    uint public oneHour = 1 hours;
    uint public oneDay = 1 days;
    bool public test = oneMinute == 60 seconds;
    bool public test1 = oneHour == 60 minutes;
    bool public test2 = oneDay == 24 hours;
}