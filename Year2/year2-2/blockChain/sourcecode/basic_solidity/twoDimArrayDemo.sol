// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.1;
contract TwodimArrayDemo {
    uint[2][3] public a; // (uint[2]) [3] 3 rows 2 columns
    uint[2][3] public b = [[1,2],[2,3],[3,4]]; 
    uint [][3] public c; // 3 arrays each is dynamic array 
    uint [2][] public d; // dynamic array its element is fixed sized array that contain 2 elements
    uint [][] public e;
    function setA() public {
        uint num = 0;
        for(uint i =0; i < 3; i++) {
            for(uint j = 0; j < 2; j++) {
                a[i][j] = num;
                num++;
            }
        }
    }
    function setC() public {
        uint num = 0;
        for(uint i =0; i < c.length; i++) {
            for(uint j = 0; j < 2; j++) {
                c[i].push(num);
                num++;
            }
        }
    }
    function setD() public {
        uint num = 0;
        uint[2] memory arr;
        for(uint i =0; i < 3; i++) {
            for(uint j = 0; j < 2; j++) {
                arr[j] = num;
                num++;
            }
            d.push(arr);
        }
    }
    function setE() public {
        uint num = 0;
        for (uint i = 0; i < 3; i++) {
            uint[] memory arr = new uint[] (2);
            for(uint j = 0; j < 2; j++) {
                arr[j] = num;
                num++;
            }
            e.push(arr);
        }
    }
    function getB() public view returns (uint[2][3] memory) {
        return b;
    }
    function getBRow(uint _row) public view returns (uint[2] memory) {
        return b[_row];
    }
    function getC() public view returns (uint[][3] memory) {
        return c;
    }
    function getCRow(uint _row) public view returns (uint[] memory) {
        return c[_row];
    }
    function getD() public view returns (uint[2][] memory) {
        return d;
    } 
    function getDRow(uint _row) public view returns (uint[2] memory) {
        return d[_row];
    }
    function getE() public view returns (uint[][] memory) {
        return e;
    }
    function getERow(uint _row) public view returns (uint[] memory) {
        return e[_row];
    }  
}