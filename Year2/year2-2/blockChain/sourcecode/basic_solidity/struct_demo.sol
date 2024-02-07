// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
contract StructDemo {
    struct Student {
        string name;
        uint id;
     } 
    mapping (uint => Student) public students;
    uint counter;
    function createStudent(uint _id, string memory _name) public {    
        Student memory student;
        /*3 ways to initilize */
        student.id = _id;
        student.name = _name;
              
        /*student = Student({
            id: _id,
            name: _name,
        });*/
        
        //student = Student(_name, _id); //short hand (functions like).
        students[counter] = student;
        counter++;
    }
    function getId(uint _index) public view returns (uint) {
        return students[_index].id;
    }
    function getName(uint _index) public view returns (string memory) {
        return students[_index].name;
    }
} 