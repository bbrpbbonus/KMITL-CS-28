// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/access/Ownable.sol";
/*abstract contract Owner {
    address public owner;
    constructor() {
        owner = msg.sender;
    }
    modifier ownerOnly() {
        require (owner == msg.sender, "Only owner is allowed");
        _;
    }
} */

//contract MyContract is Owner {
    contract MyContract is Ownable {
    //function func1() public view OwnerOnly returns (string memory) {
    function func1() public view onlyOwner returns (string memory) {    
        return "You see this since you are the owner of this contract";
    } 
}