//SPDX-License-Identifier: MIT

pragma solidity ^0.8.1;
contract FunctionDemo {
    uint public a;
    uint public value;
    bytes public data;
    function setA(uint _data) public {
        a = _data;
    }
    function getA() public view returns (uint) {
        return a;
    }
    function getContactBalance() public view returns (uint) {
        return address (this).balance;
    }
    function func1() public pure returns (uint b) {
        b = 10;
    } 
    function func2() public {
        a = a + 5;
    }
    function func3() public pure returns (uint) {
        uint temp1 = 5;
        uint temp2 = 6;
        uint temp3 = func4(temp1, temp2);
        //uint temp3 = func5(temp1, temp2);
        //uint temp3 = func6(temp1, temp2);
        return temp3;
    } 
    function func4(uint _para1, uint _para2) private pure returns (uint) {
        return (_para1 + _para2);
    }
    function func5(uint _para1, uint _para2) internal pure returns (uint) {
        return (_para1 + _para2);
    } 
    function func6(uint _para1, uint _para2) external pure returns (uint) {
        return (_para1 + _para2);
    }
    function func7() public pure returns (uint, string memory) {
        uint temp1;
        string memory temp2;
        (temp1, temp2) = func8();
        return (temp1, temp2);
    }
    function func8() private pure returns (uint, string memory) {
        return (1234, "Hello");
    }
    function func9() public payable {
        value = msg.value;
    }
    receive() payable external {
        value = msg.value;
    }
    fallback() external {
       data = msg.data; 
    }
    /*fallback() external payable {
        data = msg.data;
        value = msg.value;
    } */
    modifier aIsGreaterThan(uint _num) {
        if (a > _num) {
            _;
        }
    }
    function func10(uint _num) public view aIsGreaterThan (_num) returns(string memory str) {
        str = "Hello";
    }      
}