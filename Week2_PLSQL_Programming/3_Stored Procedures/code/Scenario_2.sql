CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department IN VARCHAR2,
  p_bonus IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * (p_bonus / 100))
  WHERE Department = p_department;
  COMMIT;
END;