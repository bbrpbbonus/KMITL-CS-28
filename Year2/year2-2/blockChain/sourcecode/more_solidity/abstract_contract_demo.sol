// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
abstract contract A {
    uint public a;
    function setA(uint _data) public {
        a = _data;
    }
    function func1() public pure returns (uint) {
        return 3;
    }
    function func2() public virtual pure returns (string memory);
    function func3() public virtual pure returns (uint); 
}
contract B is A {
    function func2() public virtual override pure returns (string memory) {
        return "from B";
    }
    function func3() public virtual override pure returns (uint) {
        return super.func1() + 5;
    }
}
contract C is A {
    function func2() public virtual override pure returns (string memory) {
        return "from C";
    }
    function func3() public virtual override pure returns (uint) {
        return super.func1() + 6;
    }
}
contract Client {
    function callFunc2(A _obj) public pure returns (string memory) {
        return _obj.func2();
    }
}
abstract contract D {
    uint public d = 5;
    function setD(uint _data) public {
        d = _data;
    }
}
contract E is D {
    uint public e;
    function setA(uint _data) public {
        e = _data;
    }
}


