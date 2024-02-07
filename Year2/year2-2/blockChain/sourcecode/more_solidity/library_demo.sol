// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.1;

library UintArray {
    function findMax(uint [] storage _arr) public view returns (uint maxNumber, uint maxIndex) {
        maxNumber = _arr[0];
        maxIndex = 0;
        for (uint i = 1; i < _arr.length; i++) {
            if (maxNumber < _arr[i]) {
                maxNumber = _arr[i];
                maxIndex = i;
            }
        }
    }
    function findMin(uint [] storage _arr) public view returns (uint minNumber, uint minIndex) {
        minNumber = _arr[0];
        minIndex = 0;
        for (uint i = 1; i < _arr.length; i++) {
            if (minNumber > _arr[i]) {
                minNumber = _arr[i];
                minIndex = i;
            }
        }
    }
    function indexOf(uint[] storage _arr, uint _value) public view returns (int) {
        for (uint i = 0; i < _arr.length; i++) {
            if (_arr[i] == _value) return int(i);
        }
        return -1;
    }
}

contract A {
    using UintArray for uint[];
    uint[] public a = [5,8,2,4,6,12,3];
    function findMaxInA() public view returns (uint maxNumber, uint maxIndex) {
        (maxNumber, maxIndex) = a.findMax();
    }
    function findMinInA() public view returns (uint minNumber, uint minIndex) {
        (minNumber, minIndex) = a.findMin();
    }  
    function whereIsinA(uint _data) public view returns (int  index) {
        index = a.indexOf(_data);
    } 
}