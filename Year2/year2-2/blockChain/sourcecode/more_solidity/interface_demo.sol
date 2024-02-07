// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;

interface IA {
    function func1() external pure returns (string memory);
    function func2() external pure returns (uint); 
}

contract A is IA {
    function func1() public pure returns (string memory) {
        return "from A";
    }
    function func2() external pure returns (uint) {
        return 3;
    }
}

contract B is IA {
    function func1() public pure returns (string memory) {
        return "from B";
    }
    function func2() public pure returns (uint) {
        return 4;
    }
}
contract Client {
    function callFunc1(IA _obj) public pure returns (string memory) {
        return _obj.func1();
    }
}
