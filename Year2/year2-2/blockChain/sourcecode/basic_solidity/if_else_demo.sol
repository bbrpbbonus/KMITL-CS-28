//SPDX-License-Identifier: MIT

pragma solidity ^0.8.1;
contract IfElseSwitchDemo {
    function ifDemo(uint _value) public pure returns (string memory) {
        string memory result = "Good Day";
        if (_value >= 10) {
            result = "Good Morning";
        }
        return result;
    }
    function ifElseDemo(uint _value) public pure returns (string memory) {
        string memory result = "Good Day";
        if (_value >= 10) {
            result = "Good Morning";
        }
        else {
            result = "Good Afternoon";
        }
        return result;
    }
    function ifElseIfDemo(uint _value) public pure returns (string memory) {
        string memory result = "Good Day";
        if (_value >= 10) {
            result = "Good Morning";
        }
        else if (_value >= 5) {
            result = "Good Afternoon";
        }
        else {
            result = "Good Night";
        }
        return result;
    }
    
} 