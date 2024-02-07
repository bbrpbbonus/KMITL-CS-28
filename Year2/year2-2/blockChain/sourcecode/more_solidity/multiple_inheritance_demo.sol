// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
contract A {
    uint public a = 5;
    function func1() public pure returns (string memory) {
        return "func1 From A";
    }
    function func3() public virtual pure returns (string memory) {
        return "func3 From A";
    }
}
contract B {
    uint public b = 6;
    function setB(uint _data) public {
        b = _data;
    }
    function func2() public pure returns (string memory) {
        return "func2 From B";
    }
    function func3() public virtual pure returns (string memory) {
        return "func3 From B";
    }
}
contract C is A, B {
    function func3() public override(A,B) pure returns (string memory) {
        return super.func3();
    }

}
contract D is B, A {
    function func3() public override(A,B) pure returns (string memory) {
        return super.func3();
    }
}


