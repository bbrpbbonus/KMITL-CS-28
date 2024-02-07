//SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
contract BankExample {
    mapping(address => uint) public balanceInAccount;
    bool private locked; 
    function getBankBalance() public view returns(uint) {
        return address(this).balance;
    }
    function depositMoney() public payable {
        balanceInAccount[msg.sender] += msg.value;
    }
    receive() external payable {
        depositMoney();
    } 
    function withdrawAllMoney() public {
        uint balanceToWithdraw = balanceInAccount[msg.sender];
        balanceInAccount[msg.sender] = 0;
        payable(msg.sender).transfer(balanceToWithdraw);
        //sendValue(msg.sender, balanceToWithdraw);
    }
    function withdrawMoney(uint _amount) public enoughMoney(_amount) {
        balanceInAccount[msg.sender] -= _amount;
        payable(msg.sender).transfer(_amount);
        //sendValue(msg.sender, _amount);
    }
    function transferAllMoney(address payable _to) public {
        uint balanceToTransfer = balanceInAccount[msg.sender];
        balanceInAccount[msg.sender] = 0;
        _to.transfer(balanceToTransfer);
        //sendValue(_to, balanceToTransfer);
    }
    function transferMoney(address payable _to, uint _amount) public enoughMoney(_amount) {
        balanceInAccount[msg.sender] -= _amount;
        _to.transfer(_amount);
        //sendValue(_to, _amount);
    }
    modifier enoughMoney(uint _amount) {
        require (balanceInAccount[msg.sender] >= _amount, "You do not have enough money in your account");
        _;
    }
    function sendValue(address _to, uint _amount) public {
        require(address(this).balance >= _amount, "Insufficient balance in Bank");
        //require (!locked, "Reentrant Guarded");
        //locked = true;
        (bool success, ) = payable (_to).call{value:_amount}("");
        require(success, "Transfer failed.");
        //locked = false;
    }
}
contract A {
    uint public balanceReceived;
    //BankExample obj;
    //uint private count;
    /*constructor(BankExample _obj) {
       obj = _obj;
    }*/
    receive() external payable {
        balanceReceived += msg.value;
        /*if (count++ == 0) {
            obj.sendValue(address (this), msg.value);
        }*/
    }
    function getContractBalance() public view returns (uint) {
        return address (this).balance;
    }
}