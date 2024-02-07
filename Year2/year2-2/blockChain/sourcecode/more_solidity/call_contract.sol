// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;

contract Called {
    uint public x;
    function setX(uint _x) public returns (uint) {
        x = _x;
        return x;
    }
    function setXandSendMoney(uint _x) public payable returns (uint) {
        x = _x;
        return x;
    }
    function getContractBalance() public view returns(uint) {
        return address (this).balance;
    }
}

contract Caller {
    function setX(Called _called, uint _x) public {
         _called.setX(_x);
    }
    function setXandSendMoney(Called _called, uint _x) public payable {
        _called.setXandSendMoney{value: msg.value}(_x);
    }
    function getXandContractBalance(Called _called) public view returns(uint _x, uint _balance) {
        return (_called.x(), _called.getContractBalance());
    }
}
