//SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;

contract MappingDemo {

    mapping(uint => bool) public a;
    mapping(address => bool) public b;
    mapping(address => mapping(uint => bool)) public c;
    uint private counter; 
    
    function setA(bool _value) public {
        a[counter] = _value;
        counter++;
    }
    function setA(uint _index, bool _value) public {
        a[_index] = _value;
    }
    function setB(bool _value) public {
        b[msg.sender] = _value;
    }
    function setC(address _addr, uint _num, bool _flag) public  {
        c[_addr][_num] = _flag;
    }
    function resetValueOfC(address _addr, uint _num) public {
        delete c[_addr][_num];
    }
    function getAValues() public view returns (bool [] memory) {
        bool [] memory values = new bool [] (counter);
        for(uint i = 0; i < counter; i++) {
            values[i] = a[i];
        }
        return values;
    }
    function getA() internal view returns (mapping(uint=>bool) storage) {
        return a;
    }
}