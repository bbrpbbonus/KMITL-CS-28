// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;

abstract contract Owner {
    address public owner;
    constructor() {
        owner = msg.sender;
    }
    modifier ownerOnly() {
        require (owner == msg.sender, "Only owner is allowed");
        _;
    }
} 

contract MyContract is Owner {
    function func1() public view ownerOnly returns (string memory) {
        return "You see this since you are the owner of this contract";
    }
}