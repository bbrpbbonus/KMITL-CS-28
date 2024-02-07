//SPDX-License-Identifier: MIT

pragma solidity ^0.8.1;
contract LoopDemo {
    function forDemo() public pure returns (uint8){
        uint8 sum;
        for (uint8 i = 1; i <= 10; i++) {
            sum+= i;
        }
        return sum;
    }
    function whileDemo() public pure returns (uint8) {
        uint8 sum; 
        uint8 i = 1;
        while(i <= 10) {
            sum+= i;
            i++;
        } 
        return sum;
    }
    function doWhileDemo() public pure returns (uint8) {
        uint8 sum; 
        uint8 i = 1;
        do  {
            sum += i;
            i++;
        } while(i <= 10);
        return sum;
    }
    function breakDemo() public pure returns (uint8) {
        uint8 sum; 
        uint8 i = 1;
        while(i <= 10) {
            sum += i;
            i++;
            if (sum >=40) {
                break;
            }
        } 
        return sum;
    }
    
    function continueDemo() public pure returns (uint8) {
        uint8 sum; 
        for (uint8 i = 1; i <= 10; i++) {
            if (sum >=40) {
                continue;
            }
            sum += i;
        } 
        return sum;
    }
    
}