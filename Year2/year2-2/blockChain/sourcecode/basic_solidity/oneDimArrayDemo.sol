// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.1;
contract OnedimArrayDemo {
    //fixed size array
    uint[3] public a = [7,8, 9]; 
    uint[4] public b;
    //dynamic size array
    uint[] public c; 
    uint [] public d = [1,2,3]; 
    function setB() public {
        b[0] = 1;
        b[1] = 2;
        b[2] = 3;
        b[3] = 4;
    }
    function setC() public {
        c.push(1);
        c.push(2);
        c.push(3);
    }
    function getA() public view returns (uint[3] memory) {
        return a;
    }
    function getALength() public view returns (uint) {
        return a.length;
    }
    function removeAAll() public {
        delete a;
    }
    function getD() public view returns (uint[] memory) {
        return d;
    }
    function pushD(uint _val) public {
        d.push(_val);
    }
    function popD() public {
        d.pop();
    }
    function getDLength() public view returns (uint) {
        return d.length;
    }
    function removeDIndex(uint _index) public {
        delete d[_index];
    }
    function setDIndex(uint _index, uint _val) public {
        if (_index > d.length - 1) {
            d.push(_val);
        }
        else {
            d[_index] = _val;
        }
    }
    function removeDAll() public {
        delete d;
    }
    function removeDCompact(uint _index) public {
        d[_index] = d[d.length-1];
        d.pop();
    }
    function localDynamicMemoryArray(uint _num) public pure returns(uint[] memory) {
        uint[] memory temp = new uint[] (_num);
        for (uint i = 0; i < _num; i++) {
            temp[i] = i;
        }
        return temp;
    }
    function func1() public view returns (uint[3] memory) {
        uint[3] memory temp = a;
        func2(temp);
        return temp;

    }
    function func2(uint[3] memory _data) private pure {
        _data[0] = 99;
    }
    function func3() public {
        uint[3] storage temp = a;
        temp[0] = 999;
    }
    /*function func4 (uint[3] calldata _data) private pure {
        _data[0] = 99;

    }*/
}
