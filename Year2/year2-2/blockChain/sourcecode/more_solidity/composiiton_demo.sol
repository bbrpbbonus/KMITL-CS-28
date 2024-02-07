// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;

contract Car {
    address public owner;
    string public model;
    constructor(address _owner, string memory _model) {
        owner = _owner;
        model = _model;
    }
}

contract CarFactory {
    mapping (uint => Car) public cars;
    uint private index;

    function create(address _owner, string memory _model) public {
        Car car = new Car(_owner, _model);
        cars[index++] = car;
    }

    function getCar(uint _index) public view returns (address owner, string memory model) {
        Car car = cars[_index];
        return (car.owner(), car.model());
    }
}
