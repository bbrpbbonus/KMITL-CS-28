// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
contract GolbalVar {
    bytes public data;
    bytes4 public data4;
    uint public value;
    address owner;
    //block variable and functions
    function blockBaseFee() public view returns (uint) { 
        return block.basefee;
    }
    function blockChainId() public view returns (uint) { 
        return block.chainid;
    }
    function blockCoinbaseAddress() public view returns (address payable) {
        return block.coinbase;
    }
    function blockDifficulty() public view returns (uint) {
        return block.difficulty;
    }
    function blockgasLimit() public view returns (uint) {
        return block.gaslimit;
    }
    function currentBlockNumber() public view returns (uint) {
        return block.number;
    }
    function currentBlockTimeStamp() public view returns (uint) {
        return block.timestamp;
    }
    function gasLeft() public view returns (uint) {
        return gasleft();
    }
    //msg variable
    constructor() {
        owner = msg.sender;
    }
    function getSenderAddress() public view returns (address) {
        return msg.sender;
    }
    /*function getMsgData(uint _data) public pure returns (bytes memory) {
        _data += 1;
        return msg.data;
    }*/
    function getMsgData(uint _data) public pure returns (bytes4 ) {
        _data += 1;
        return msg.sig;
    }
    fallback() external {
        data = msg.data;
        data4 = msg.sig;
    }
    function receiveMoney() public payable {
        value = msg.value;
    }
    function getContractBalance() public view returns(uint) {
        return address (this).balance;
    }
    //tx variable
    function getTxGasPrice() public view returns (uint) {
        return tx.gasprice;
    }
    function getTxOrigin() public view returns (address) {
        return tx.origin;
    }
    //hash function
    function hashFromKeccak256(bytes memory _data)  public pure returns (bytes32) {
        bytes32 hashValue = keccak256(_data);
        return hashValue;
    }
    function hashFromSha256(bytes memory _data)  public pure returns (bytes32) {
        bytes32 hashValue = sha256(_data);
        return hashValue;
    }
    function hashFromRipemd160(bytes memory _data)  public pure returns (bytes20) {
        bytes20 hashValue = ripemd160(_data);
        return hashValue;
    }
    //abi
    function abiEncode(bytes1 _data1, bytes2 _data2) public pure returns (bytes memory) {
        return abi.encode(_data1, _data2);
    }
    function abiEncodePacked(bytes1 _data1, bytes2 _data2) public pure returns (bytes memory) {
        return abi.encodePacked(_data1, _data2);
    }
    function abiDecode(bytes memory _data) public pure returns (uint8, uint16) {
        (uint8 data1, uint16 data2) = abi.decode(_data, (uint8, uint16));
        return (data1, data2);
    }
    //selfdestruct
    function destroySmartContract(address payable _to) ownerOnly public {
        selfdestruct(_to);
    }
    modifier ownerOnly() {
        require(owner == msg.sender, "You are not the owner");
        _;
    }
}

contract A {
    function callGlobalVar(GolbalVar _obj) public view returns (address) {
        return _obj.getSenderAddress();
    }
    function callGlobalVarTx(GolbalVar _obj) public view returns (address) {
        return _obj.getTxOrigin();
    }
}
