// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;

contract AggregatedContract {
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

contract DependentContract {
    AggregatedContract public agg;
    constructor (AggregatedContract _contract) {
        agg = _contract;
    }
    function setX(uint _x) public {
         agg.setX(_x);
    }
    function setXandSendMoney(uint _x) public payable {
        agg.setXandSendMoney{value: msg.value}(_x);
    }
    function getXandContractBalance() public view returns(uint _x, uint _balance) {
        return (agg.x(), agg.getContractBalance());
    }
}