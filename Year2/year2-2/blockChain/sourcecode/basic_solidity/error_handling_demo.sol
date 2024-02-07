// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.1;
contract ErrorHandlingDemo {
    function requireExample (uint _data) public pure returns (bool) {
        require(_data % 2 == 0, "The input must be even number");
        return true;
    }
    function assertExample() public pure returns (bool) {
        uint temp = 5;
        assert (temp+1 == 6);
        return true;
    }
    function revertExample(uint _data) public pure returns (bool) {
        if (_data %2 != 0) {
            revert("The input must be even number");
        }
        return true;
    }
}