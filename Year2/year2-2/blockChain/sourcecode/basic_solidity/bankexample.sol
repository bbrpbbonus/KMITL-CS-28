//SPDX-License-Identifier: MIT

pragma solidity ^0.8.1;

contract BankExample {

    mapping(address => uint) public balanceInAccount;

    function getBankBalance() public view returns(uint) {
        return address(this).balance;
    }

    function depositMoney() public payable {
        balanceInAccount[msg.sender] += msg.value;
    }

    function withdrawAllMoney() public {
        uint balanceToWithDraw = balanceInAccount[msg.sender];
        balanceInAccount[msg.sender] = 0;
        payable(msg.sender).transfer(balanceToWithDraw);
    }
    
    function withdrawMoney(uint _amount) public enoughMoney(_amount) {
        uint balanceBefore = balanceInAccount[msg.sender];
        uint balanceContractBefore = getBankBalance();
        balanceInAccount[msg.sender] -= _amount;
        payable(msg.sender).transfer(_amount);
        assert(balanceInAccount[msg.sender] == (balanceBefore - _amount));
        assert(getBankBalance() == (balanceContractBefore - _amount));
    }
    
    function transferAllMoney(address payable _to) public {
        uint balanceToTransfer = balanceInAccount[msg.sender];
        balanceInAccount[msg.sender] = 0;
        _to.transfer(balanceToTransfer);
    }
    function transferMoney(address payable _to, uint _amount) public enoughMoney(_amount) {
        balanceInAccount[msg.sender] -= _amount;
        _to.transfer(_amount);
    }
    modifier enoughMoney(uint _amount) {
        require (balanceInAccount[msg.sender] >= _amount, "You do not have enough money in your account");
        _;
    }
}