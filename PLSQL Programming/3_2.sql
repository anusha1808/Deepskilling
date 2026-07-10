CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(bonus IN NUMBER, dept IN VARCHAR2) IS
BEGIN
  UPDATE Employees SET Salary = Salary + bonus WHERE Department = dept;
END;
/
