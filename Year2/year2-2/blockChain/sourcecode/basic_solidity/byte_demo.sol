// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.1;
contract ByteDemo {
    bytes1 public a;
    bytes3 public b;
    bytes3[] public c;
    function setA(bytes1 _data) public {
        a = _data;
    }
    function setB(bytes3 _data) public {
        b = _data;
    }
    function getBIndex(uint _index) public view returns (bytes1) {
        return b[_index];
    }
    function func1() public pure returns (bytes3) {
        bytes3 temp = 0x484950; 
        func2(temp);
        return temp;
    }
    function func2(bytes3 _data) private pure {
        _data = 0x505152;
    } 
    function getLengthB() public view returns (uint) {
        return b.length;
    }
    function addC(bytes3 _data) public {
        c.push(_data);
    }
    function getC() public view returns (bytes3[] memory) {
        return c;
    }
}