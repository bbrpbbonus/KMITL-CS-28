// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
contract A {
    uint public a;
    uint private b;
    uint internal c;
    function setA(uint _data) public {
        a = _data;
    } 
    function setB(uint _data) public  {
        b = _data;
    }
    function getB() public view returns (uint) {
        return b;
    }
    function setC(uint _data) public {
        c = _data;
    }
    function getC() public view returns (uint) {
        return c;
    }
    function func1() public pure virtual returns (uint) {
        return 3;
    }
    function func4() internal pure returns (uint) {
        return 1 + 2;
    }
    function func5() private pure returns (uint) {
        return 1 + 2;
    }
    function func6() external pure returns (uint) {
        return 1 + 2;
    }
}
contract B is A {
    uint public d;
    function setD(uint _data) public {
        d = _data;
    }
    function func1() public pure override returns (uint) {
        uint temp = super.func1();
        return temp * 2;
    }
    function func2() public view returns (uint) {
        //return b;
        return getB();
    }
    function func3() public view returns (uint) {
        return c;
    }
    function callFunc4() public pure returns (uint) {
        return func4();
    }
    /*function callFunc5() public pure returns (uint) {
        return func5();
    }*/
    /*function callFunc6() public pure returns (uint) {
        return func6();
    }*/
    function callFunc6AsExternal() public returns (uint) {
        A a = new A();
        return a.func6();
    }
}

contract C is B {
    /*function func1() public pure override returns (uint) {
        uint temp = super.func1();
        return temp * 3;
    }*/
}

contract Client {
    function callFunc1(A _obj) public pure returns (uint) {
        return _obj.func1();
    }
}
