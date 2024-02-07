--Inner Join 1
SELECT
    *
FROM
    EMPLOYEE , SETPROVINCE
    where (EMPLOYEE.spvCode = SETPROVINCE.spvCode)

-- Inner Join 2
SELECT
    *
FROM
    EMPLOYEE 
    INNER JOIN SETPROVINCE
    ON (EMPLOYEE.spvCode = SETPROVINCE.spvCode)    



-- Outer Join 1
SELECT
    *
FROM SETPROVINCE , EMPLOYEE
    where SETPROVINCE.spvCode = EMPLOYEE.spvCode(+)

-- Outer Join 2
SELECT 
    * 
FROM SETPROVINCE 
    Left Outer Join EMPLOYEE 
    ON (SETPROVINCE.spvCode = EMPLOYEE.spvCode)
