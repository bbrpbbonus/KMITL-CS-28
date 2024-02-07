// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.1;
contract OperatorsDemo {
    function add(int num1, int num2) public pure returns (int) {
        return num1 + num2;
    }
    function subtract(int num1, int num2) public pure returns (int) {
        return num1 - num2;
    }
    function multiply (int num1, int num2) public pure returns (int) {
        return num1 * num2;
    }
    function divide (int num1, int num2) public pure returns (int) {
        require(num2 != 0, "Diviser cannot be zero");
        return num1 / num2;
    }
    function modulo (int num1, int num2) public pure returns (int) {
        //require(num2 != 0, "Diviser cannot be zero");
        return num1 % num2;
    }
    function power (int num1, uint num2) public pure returns (int) {
        return num1 ** num2;
    }
    function precedenceDemo() public pure returns (int) {
        return 1 + 2 * 3;
    }
    function incrementSuffixDemo() public pure returns (int a ,int b) {
        a = 2; 
        b;
        b = a++;
    }
    function incrementPrefixDemo() public pure returns (int a ,int b) {
        a = 2; 
        b;
        b = ++a;
    }
    function assignmentDemo() public pure returns (int a ,int b) {
        a += 5;
        b = 2;
        b *= 6;
    }
    function relationalDemo() public pure returns (bool, bool, bool, bool) {
        
        return (5 > 6, 6 < 7, 7 == 8, 7 != 8);
    }
    function logicalOperatorDemo() public pure returns (bool, bool) {
        uint a = 5;
        uint b = 6;
        uint c = 7;
        return(a == 5 && b == 7, a!= 5 || b <= c);

    }
 
}