select 
    EMPNO,
    FNAME,
    SEX,
    SALARY,
    WORKSTATUS,
    EMPLOYEE.DEPTCODE,
    DEPTNAME,
    SCTCODE,
    SCTTNAME,
    SPRCODE,
    SPRTNAME,
    SPVCODE,
    SPVTNAME
from EMPLOYEE
    INNER JOIN department
    ON department.deptcode = employee.deptcode
    INNER JOIN SETPROVINCE 
    ON SETPROVINCE.spvcode = employee.spvcode
    INNER JOIN SETPART
    ON SETPART.SPRCODE = SETPROVINCE.spvsprcode
    INNER JOIN SETCOUNTRY
    ON SETCOUNTRY.SCTCODE = SETPART.SPRSCTCODE
ORDER BY 
    employee.empno