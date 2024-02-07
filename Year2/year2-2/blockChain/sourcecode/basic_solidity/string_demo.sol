//SPDX-License-Identifier: MIT
pragma solidity 0.8.14;
contract StringDemo {
    string public a = "Hello World";
    function setA (string memory _data) public {
        a = _data;
    }
    function getLength() public view returns (uint) {
        return bytes (a).length;
    }
    function setAIndex(uint _index, bytes1 _data) public {
        if (_index >= getLength()) {
            bytes (a).push(_data);
        }
        else {
            bytes (a)[_index] = _data;
        }  
    }
    function getCharAt(uint _index) public view returns (bytes1) {
        uint length = getLength();
        if (_index >= length) {
            _index = length-1; 
        }
        return bytes (a)[_index];
    }
    function concatA(string memory _data) public {
        a  = string.concat(a, " ", _data);
    }
    function isEqual(string memory _data) public view returns (bool) {
        return (keccak256(abi.encodePacked(a)) == keccak256(abi.encodePacked(_data)));
    }
}