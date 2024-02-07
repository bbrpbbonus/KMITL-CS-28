//SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/utils/Address.sol";
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/security/ReentrancyGuard.sol";
contract BankExampleOPZ is ReentrancyGuard{
    using Address for address payable;
    using Address for address;
    mapping(address => uint) public balanceInAccount;
    function getBankBalance() public view returns(uint) {
        return address(this).balance;
    }
    function depositMoney() public payable {
        balanceInAccount[msg.sender] += msg.value;
    }
    receive() external payable {
        depositMoney();
    } 
    function isContractAddress(address _addr) public view returns(bool) {
        return _addr.isContract();
    }
    function withdrawAllMoney() public nonReentrant {
        uint balanceToWithdraw = balanceInAccount[msg.sender];
        balanceInAccount[msg.sender] = 0;
        payable (msg.sender).sendValue(balanceToWithdraw);
        //sendValue(payable (msg.sender), balanceToWithdraw);
    }
    function withdrawMoney(uint _amount) public enoughMoney(_amount) {
        balanceInAccount[msg.sender] -= _amount;
        sendValue(payable (msg.sender), _amount);
    }
    function transferAllMoney(address payable _to) public {
        uint balanceToTransfer = balanceInAccount[msg.sender];
        balanceInAccount[msg.sender] = 0;
        sendValue(payable (_to), balanceToTransfer);
    }
    function transferMoney(address payable _to, uint _amount) public { //enoughMoney(_amount) {
        balanceInAccount[msg.sender] -= _amount;
        sendValue(payable (_to), _amount);
    }
    function sendValue(address payable _to, uint _amount) public nonReentrant {
        _to.sendValue(_amount);
    }
    modifier enoughMoney(uint _amount) {
        require (balanceInAccount[msg.sender] >= _amount, "You do not have enough money in your account");
        _;
    }
}
contract A {
    uint public balanceReceived;
    BankExampleOPZ obj;
    uint private count;
    constructor(BankExampleOPZ _obj) {
       obj = _obj;
    }
    receive() external payable {
        balanceReceived += msg.value;
        if (count++ == 0) {
            //obj.transferMoney(payable (this), msg.value);
            obj.sendValue(payable (this), msg.value);
        }
    }
    function getContractBalance() public view returns (uint) {
        return address (this).balance;
    }
}